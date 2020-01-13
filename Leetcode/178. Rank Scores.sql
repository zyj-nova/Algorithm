SELECT Score, Rank
FROM
    (SELECT Score,
        @curRank := IF(@prevRank = Score, @curRank+0, @curRank:= @curRank+1) AS Rank,
    @prevRank
:= Score
FROM Scores,
(
SELECT @curRank :=0, @prevRank := NULL
)
r
ORDER BY Score DESC) s
