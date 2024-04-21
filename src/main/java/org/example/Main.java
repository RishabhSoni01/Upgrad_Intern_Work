package org.example;

public class Main {


    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];


        for (int i = 0; i < featureSet.length; i++) {
            String[] features = featureSet[i];


            for (String feature : features) {
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    break;
                }
            }
        }

        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return opinion;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        review = review.toLowerCase();
        if (review.contains(pattern)) {
            for (String posWord : posOpinionWords) {
                if (review.contains(posWord)) {
                    opinion = 1;
                    break;
                }
            }
            for (String negWord : negOpinionWords) {
                if (review.contains(negWord)) {
                    opinion = -1;
                    break;
                }
            }
        }
        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;


        if (review.toLowerCase().contains(feature.toLowerCase())) {

            for (String posWord : posOpinionWords) {
                if (review.toLowerCase().contains(posWord.toLowerCase())) {
                    opinion = 1;
                    break;
                }
            }
            for (String negWord : negOpinionWords) {
                if (review.toLowerCase().contains(negWord.toLowerCase())) {
                    opinion = -1;
                    break;
                }
            }
        }

        return opinion;
    }
}