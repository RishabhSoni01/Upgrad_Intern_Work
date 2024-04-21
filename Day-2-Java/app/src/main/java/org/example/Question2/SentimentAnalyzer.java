package org.example.Question2;

import java.util.Arrays;

public class SentimentAnalyzer {
// Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
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
// First invoke checkForWasPhrasePattern and
// if it cannot find an opinion only then invoke checkForOpinionFirstPattern

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return opinion;
    }

// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
// You can first look for positive opinion. If not found, only then you can look for negative opinion

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        if (review.contains(pattern)) {
            for (String posWord : posOpinionWords) {
                if (review.contains(posWord)) {
                    opinion = 1;
                    break;
                }
            }
            if (opinion == 0) {
                for (String negWord : negOpinionWords) {
                    if (review.contains(negWord)) {
                        opinion = -1;
                        break;
                    }
                }
            }
        }
        return opinion;
    }

// You can first look for positive opinion. If not found, only then you can look for negative opinion

    private static <negOpinionWords> int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords)
    {
        int opinion = 0;
        String[] sentences = review.split("\\.");
        for (String sentence : sentences) {
            if (sentence.contains(feature)) {
                for (String posWord : posOpinionWords) {
                    if (sentence.contains(posWord)) {
                        opinion = 1;
                        break;
                    }
                }
                if (opinion == 0) {
                    for (String negWord : negOpinionWords) {
                        if (sentence.contains(negWord)) {
                            opinion = -1;
                            break;
                        }
                    }
                }
                if (opinion != 0) {
                    break;
                }
            }
        }
        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definitely will be a frequent flyer! Francisco was very attentive";
        String[][] featureSet = {
                {"ambiance", "ambience", "atmosphere", "decor"},
                {"dessert", "ice cream", "desert"},
                {"food"},
                {"soup"},
                {"service", "management", "waiter", "waitress", "bartender", "staff", "server"}
        };
        String[] posOpinionWords = {"good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious"};
        String[] negOpinionWords = {"slow", "bad", "horrible", "awful", "unprofessional", "poor"};

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}