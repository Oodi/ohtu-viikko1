package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String[] scoresToString = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            m_score1++;
        } else {
            m_score2++;
        }
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return sameScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return scoreMoreThan4();
        }
            return scoresToString[m_score1] + "-" + scoresToString[m_score2];
        
    }

    private String scoreMoreThan4() {
        String score = "";
        int diff = Math.abs(m_score1 - m_score2);
        if (diff == 1) {
            score += "Advantage ";
        } else {
            score += "Win for ";
        }
        if (m_score1 > m_score2) {
            score += "player1";
        } else {
            score += "player2";
        }
        return score;
    }

    private String sameScore(int score) {
        if (score >= scoresToString.length) {
            return "Deuce";
        }
        return scoresToString[score] + "-All";
    }
}
