package entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 利用PSO算法优化kmenas聚类中心的选择 k = 2
 */
public class Particle {
    public static void main(String[] args) throws IOException {
        PSO pso = new PSO();
        pso.readfile();
        pso.createpso();
        pso.Initialize();
        pso.Search();
    }
}

class Agent {

    public static int iPOSNum = 20;// 粒子个数
    public static int iAgentDim = 2;// 粒子维度

    public static int ikmeans = 2; // 聚类中心数

    private final double w = 0.9;
    private final double c1 = 1;
    private final double c2 = 1;
    public double[] dpos = new double[iAgentDim * ikmeans];// 粒子的位置
    public double[] dpbest = new double[iAgentDim * ikmeans]; // 粒子本身的最优位置
    public double[] dv = new double[iAgentDim * ikmeans]; // 粒子的速度
    private double m_dFitness = 0;
    public double m_dBestfitness; // m_dBestfitness 粒子本身的最优解，适应度

    private Random random = new Random();
    public static double[] gbest = new double[iAgentDim * ikmeans];
    public static List<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();

    public void readAgent() throws IOException {
        File file = new File("E://cluster.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while ((s = br.readLine()) != null) {
            String record = s.toString();
            String[] fields = record.split(" ");
            List<Double> tmplist = new ArrayList<Double>();

            // 由于第一个是K1编号，所以不录入
            for (int i = 1; i < fields.length; ++i) {
                tmplist.add(Double.parseDouble(fields[i]));
            }
            result.add((ArrayList<Double>) tmplist);
        }
        br.close();

    }

    // 对粒子的位置和速度进行初始化
    public void agentinitialize() {
        // 产生俩个不同的随机数,范围在[0,size-1]
        Set<Integer> set = new HashSet<Integer>();
        // 以系统时间为种子
        Random ran = new Random();
        // 存放结果的数组
        int[] results = new int[ikmeans];

        for (int i = 0; i < ikmeans; i++) {
            // 产生一个范围小于result.size()的数。
            int temp = ran.nextInt(result.size());

            // 若此数已存在，则添加失败
            boolean flag = set.add(temp);
            if (flag) {
                results[i] = temp;
            } else {
                --i;// 这次不算，重头来过
            }
        }
        int k = 0;

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < result.get(results[i]).size(); j++) {
                dpos[k] = result.get(results[i]).get(j);
                dv[k] = dpbest[k] = dpos[k];
                k++;
            }

        }

    }

    public void UpdateFitness() {
        // 此处，如果不清楚有几个聚类中心的话，就比较难做，所以还是回归到俩个聚类中心
        // 俩个数组分别存放俩个聚类中心
        double[] k1 = new double[iAgentDim];
        double[] k2 = new double[iAgentDim];
        // k1,k2分别所属的簇的适应度值
        double m_dFitnessk1 = 0;
        double m_dFitnessk2 = 0;

        for (int i = 0; i < k1.length; i++) {
            k1[i] = dpos[i];
        }

        for (int i = 0; i < k2.length; i++) {
            k1[i] = dpos[i + k1.length];
        }

        // 计算适应度函数的值
        for (int i = 0; i < result.size(); i++) {
            double disk1 = 0; // 一个点分别到k1，k2的距离，没有开根号
            double disk2 = 0;

            for (int j = 0; j < result.get(i).size(); j++) {
                disk1 += Math.pow(result.get(i).get(j) - k1[j], 2);
                disk2 += Math.pow(result.get(i).get(j) - k2[j], 2);

                // 这个点距离k1比较近，是属于k1
                if (disk1 <= disk2)
                    m_dFitnessk1 += disk1;
                else
                    m_dFitnessk2 += disk2;

            }
        }

        m_dFitness = m_dFitnessk1 + m_dFitnessk2;// 该粒子的总适应度

        if (m_dFitness < m_dBestfitness) {
            m_dBestfitness = m_dFitness;
            for (int i = 0; i < iAgentDim * ikmeans; i++) {
                dpbest[i] = dpos[i];
            }
        }

        System.out.println(m_dBestfitness);
    }

    // 更新粒子的速度和位置
    public void UpdatePos() {
        for (int i = 0; i < iAgentDim * ikmeans; i++) {
            dv[i] = w * dv[i] + c1 * random.nextDouble() * (dpbest[i] - dpos[i])
                    + c2 * random.nextDouble() * (gbest[i] - dpos[i]);
            dpos[i] = dpos[i] + dv[i];
        }
    }

}

class PSO {
    private Agent[] agent;
    private final int iStep = 10;// 迭代次数

    private double m_dBestFitness; // 每个粒子的个体极值

    private int m_iTempPos; // 记录粒子全局最优值对应的下标

    public PSO() {
    }

    public void readfile() throws IOException {
        Agent fristagent = new Agent();
        fristagent.readAgent();
    }

    // 创建粒子

    public void createpso() {
        m_dBestFitness = 10000;
        agent = new Agent[Agent.iPOSNum];

        for (int i = 0; i < Agent.iPOSNum; i++) {
            agent[i] = new Agent();
            agent[i].agentinitialize();
        }
    }

    public void Initialize() {
        for (int i = 0; i < Agent.iPOSNum; i++) {
            agent[i].m_dBestfitness = 10000;// 将每个粒子的适应度初始为10000
            agent[i].UpdateFitness();
        }
    }

    public void Search() {
        int k = 0;
        while (k < iStep) {
            m_iTempPos = 99;// 记录粒子全局最优值对应的下标

            // 对所有粒子的局部极值进行比较，更新全局极值
            for (int i = 0; i < Agent.iPOSNum; i++) {
                if (agent[i].m_dBestfitness < m_dBestFitness) {
                    m_dBestFitness = agent[i].m_dBestfitness;
                    m_iTempPos = i;
                }

            }
            // 如果找到了全局极值，则更新全局极值，通过前面找到的下标
            if (m_iTempPos != 99) {
                for (int i = 0; i < Agent.iAgentDim * Agent.ikmeans; i++) {
                    Agent.gbest[i] = agent[m_iTempPos].dpbest[i];
                }
            }

            // 更新所有粒子的位置和方向
            for (int i = 0; i < Agent.iPOSNum; i++) {
                agent[i].UpdateFitness();
                agent[i].UpdatePos();
            }

            k++;
        } // 循环结束

        System.out.println("After " + k + " steps " + "the best value is " + m_dBestFitness);
        System.out.print("The best position is :");

        for (int i = 0; i < Agent.iAgentDim * Agent.ikmeans; i++) {

            System.out.print(Agent.gbest[i] + " ");
        }
    }

}