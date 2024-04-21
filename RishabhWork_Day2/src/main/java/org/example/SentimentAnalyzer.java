package org.example;
import java.util.Arrays;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];

        for (int i = 0; i < featureSet.length; i++) {
            String[] featureSynonyms = featureSet[i];
            for (String feature : featureSynonyms) {
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
        if (review.toLowerCase().contains(pattern)) {
            for (String posWord : posOpinionWords) {
                if (review.toLowerCase().contains(pattern + posWord.toLowerCase())) {
                    opinion = 1;
                    break;
                }
            }
            if (opinion == 0) {
                for (String negWord : negOpinionWords) {
                    if (review.toLowerCase().contains(pattern + negWord.toLowerCase())) {
                        opinion = -1;
                        break;
                    }
                }
            }
        }
        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String[] sentences = review.split("\\.");
        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            for (String word : words) {
                for (String posWord : posOpinionWords) {
                    if (word.equalsIgnoreCase(posWord) && sentence.toLowerCase().contains(feature.toLowerCase())) {
                        opinion = 1; // Positive opinion found
                        break;
                    }
                }
                if (opinion != 0) {
                    break;
                }
                for (String negWord : negOpinionWords) {
                    if (word.equalsIgnoreCase(negWord) && sentence.toLowerCase().contains(feature.toLowerCase())) {
                        opinion = -1;
                        break;
                    }
                }
                if (opinion != 0) {
                    break;
                }
            }
            if (opinion != 0) {
                break;
            }
        }
        return opinion;
    }

    public static void main(String[] args) {
            String review1   = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
            String review2 = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
            String[][] featureSet = {
                    { "ambiance", "ambience", "atmosphere", "decor" },
                    { "dessert", "ice cream", "desert" },
                    { "food" },
                    { "soup" },

                    { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
            };
            String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };
            String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

            int[] featureOpinions1 = detectProsAndCons(review1,featureSet, posOpinionWords, negOpinionWords);
            int[] featureOpinions2 = detectProsAndCons(review2,featureSet, posOpinionWords, negOpinionWords);
            System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions1));
            System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions2));
        }
    }

