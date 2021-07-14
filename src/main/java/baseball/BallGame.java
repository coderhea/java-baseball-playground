package baseball;

import java.util.List;
import java.util.Objects;

public class BallGame {

    private final List<Ball> systemBallsList;

    BallGame(BallsGenerator ballsGenerator) {
        this.systemBallsList = ballsGenerator.getSystemBallsList();
    }
    //하나의 Game에서 사용자는 반복해 맞추나, 컴퓨터는 유지

    //정리 필요!! this not in Static content
    public BallStatus matchToStrike(Ball usrBall) {
        return systemBallsList.stream()
                .filter(ball -> ball.equals(usrBall))
                .findFirst()
                .map(o -> BallStatus.STRIKE)
                .orElse(BallStatus.NOTHING);
    }

    public BallStatus matchToBall(Ball usrBall) {
        return systemBallsList.stream()
                .filter(ball -> !ball.isSameSlotOf(usrBall) && ball.isSameNumOf(usrBall))
                .findFirst()
                .map(o -> BallStatus.BALL)
                .orElse(BallStatus.NOTHING);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallGame ballGame = (BallGame) o;
        return Objects.equals(systemBallsList, ballGame.systemBallsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemBallsList);
    }
}
