package tn.esprit;

import entities.Claim;

public class CompareClaims implements Comparable<CompareClaims>{
	private int editDistance;
    private int lengthOfLCS;
    public double scoreForLD;
    public double scoreForLCS;
    public double overallTextDiffScore;
    private Claim c ;
	public CompareClaims() {
		super();
	}
	public int LevensthienDistance(String one, String two) {
		if (one == null && two != null) {editDistance = two.length();}
		if (one != null && two == null) {editDistance = one.length();}
		if (one == null && two == null) {editDistance = 0;}

		int lengthOne = one.length();
		int lengthTwo = two.length();

		int distance[][] = new int[lengthOne + 1][lengthTwo + 1];

		for (int i = 0; i < lengthOne + 1; i++) {
			for (int j = 0; j < lengthTwo + 1; j++) {
				distance[i][j] = 0;
			}
		}
		for (int i = 0; i < lengthOne + 1; i++) {
			for (int j = 0; j < lengthTwo + 1; j++) {
				if (i == 0) {
					distance[i][j] = j;
				} else if (j == 0) {
					distance[i][j] = i;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)) {
					distance[i][j] = Math.min(Math.min(distance[i - 1][j - 1], distance[i - 1][j]), distance[i][j - 1]);
				} else if (one.charAt(i - 1) != two.charAt(j - 1)) {
					distance[i][j] = 1
							+ Math.min(Math.min(distance[i][j - 1], distance[i - 1][j]), distance[i - 1][j - 1]);
				}
			}
		}
		editDistance = distance[lengthOne][lengthTwo];
		return editDistance;

	}
	 public int LongestCommonSubsequence(String one, String two) {
	        String str = "";

	        if (one == null || two == null) {lengthOfLCS = 0;} else {
	            int array[][] = new int[one.length() + 1][two.length() + 1];
	            for (int i = 0; i <= one.length(); i++) {
	                array[i][0] = 0;
	            }
	            for (int j = 0; j <= two.length(); j++) {
	                array[0][j] = 0;
	            }
	            for (int i = 0; i <= one.length(); i++) {
	                for (int j = 0; j <= two.length(); j++) {
	                    if (i == 0 || j == 0) {
	                        array[i][j] = 0;
	                    } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
	                        array[i][j] = array[i - 1][j - 1] + 1;
	                        if (array[i][j] > array[i - 1][j] && array[i][j] > array[i][j - 1]) {
	                            str = str + (one.charAt(i - 1));
	                        }
	                    } else if (array[i - 1][j] <= array[i][j - 1]) {
	                        array[i][j] = array[i][j - 1];
	                    } else {
	                        array[i][j] = array[i - 1][j];
	                    }
	                }
	            }
	            lengthOfLCS = array[one.length()][two.length()];
	        }
         return lengthOfLCS;
	    }
	 public void CodeComparisonScoresHelper(String fileOne, String fileTwo) {
	        double maxLength = Math.max(fileOne.length(), fileTwo.length());

	        int amountOfChangesLD = LevensthienDistance(fileOne, fileTwo);
	        int amountLCS = LongestCommonSubsequence(fileOne, fileTwo);

	        double LDScore = (maxLength - amountOfChangesLD) / maxLength * 100;
	        double LCSScore = amountLCS / maxLength * 100;
	        double overallScore = (LCSScore + LDScore) / 2;

	        if (LDScore > scoreForLD) {
	            scoreForLD = LDScore;
	        }
	        if (LCSScore > scoreForLCS) {
	            scoreForLCS = LCSScore;
	        }
	        if (overallScore > overallTextDiffScore) {
	            overallTextDiffScore = overallScore;
	        }
	    }
	@Override
	public int compareTo(CompareClaims o) {
		if(this.editDistance<o.editDistance &&  this.lengthOfLCS>o.lengthOfLCS)
		{
			return -1;
		}
		else if(this.editDistance>o.editDistance &&  this.lengthOfLCS<o.lengthOfLCS)
		{
			return 1;
		}
		return 0;
	}
	public int getEditDistance() {
		return editDistance;
	}
	public void setEditDistance(int editDistance) {
		this.editDistance = editDistance;
	}
	public int getLengthOfLCS() {
		return lengthOfLCS;
	}
	public void setLengthOfLCS(int lengthOfLCS) {
		this.lengthOfLCS = lengthOfLCS;
	}
	public double getScoreForLD() {
		return scoreForLD;
	}
	public void setScoreForLD(double scoreForLD) {
		this.scoreForLD = scoreForLD;
	}
	public double getScoreForLCS() {
		return scoreForLCS;
	}
	public void setScoreForLCS(double scoreForLCS) {
		this.scoreForLCS = scoreForLCS;
	}
	public double getOverallTextDiffScore() {
		return overallTextDiffScore;
	}
	public void setOverallTextDiffScore(double overallTextDiffScore) {
		this.overallTextDiffScore = overallTextDiffScore;
	}
	public Claim getC() {
		return c;
	}
	public void setC(Claim c) {
		this.c = c;
	}
	
}
