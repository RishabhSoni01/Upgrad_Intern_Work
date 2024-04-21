package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SentimentAnalyzer {
// Tip: labeled continue can be used when iterating featureSet + convert review to lower-case

    Set<String> posset;
    Set<String> noset;
    Set<String> allfetures;
    String[] sentences;

    public SentimentAnalyzer(String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords,String review){

        posset=new HashSet<>();
        noset=new HashSet<>();
        allfetures=new HashSet<>();
        sentences=review.split(" ");

        for(int i=0;i<sentences.length;i++){
            sentences[i] = sentences[i].toLowerCase();
            sentences[i]=sentences[i].replaceAll("[^a-z]", "");
        }

        System.out.println("sentences array: "+Arrays.toString(sentences));

        for(String[] arr2:featureSet){
            allfetures.addAll(Arrays.asList(arr2));
        }

        posset.addAll(Arrays.asList(posOpinionWords));
        noset.addAll(Arrays.asList(negOpinionWords));



    }

    public  int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {

        int[] featureOpinions = new int[featureSet.length]; // output
        // your code ~ you will be invoking getOpinionOnFeature
        int i=0;
        for(String[] arr1:featureSet){
            featureOpinions[i++]=getOpinionOnFeature(review,arr1,posOpinionWords,negOpinionWords);
        }


        return featureOpinions;
    }
// First invoke checkForWasPhrasePattern and
// if it cannot find an opinion only then invoke checkForOpinionFirstPattern

    private  int getOpinionOnFeature(String review, String[] feature, String[] posOpinionWords, String[] negOpinionWords) {
// your code
        int opinion = checkForOpinionFirstPattern(review,feature,posOpinionWords,negOpinionWords);
        if(opinion!=0)return opinion;
        opinion =checkForWasPhrasePattern(review,feature,posOpinionWords,negOpinionWords);
        return opinion;
    }

// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
// You can first look for positive opinion. If not found, only then you can look for negative opinion

    private  int checkForWasPhrasePattern(String review, String[] feature, String[] posOpinionWords, String[] negOpinionWords) {
        int f = 0;

        System.out.println("Opinions on Features: " + Arrays.toString(feature));

        Set<String> currfeatureset = new HashSet<>();

        currfeatureset.addAll(Arrays.asList(feature));


        int opinion=0;

        for(String sentence:this.sentences){
            if(f==1){
                if(posset.contains(sentence))return 1;
                else if(noset.contains(sentence))return -1;
            }else{
                if(currfeatureset.contains(sentence))f=1;
            }
        }
// your code
        return opinion;
    }

// You can first look for positive opinion. If not found, only then you can look for negative opinion

    private  int checkForOpinionFirstPattern(String review, String[] feature, String[] posOpinionWords,String[] negOpinionWords)
    {
// Extract sentences as feature might appear multiple times. // split() takes a regular expression and "." is a special
// for regular expression. So, escape it to make it work!!

        System.out.println("executed");

        Set<String> currfeatureset = new HashSet<>();

        currfeatureset.addAll(Arrays.asList(feature));


        int opinion =0;



        for(String sentence:this.sentences){
            if(posset.contains(sentence)){
                opinion =1;
            } else if (noset.contains(sentence)) {
                opinion =-1;
            }else{
                if(allfetures.contains(sentence)){
                    if(currfeatureset.contains(sentence)&&( (opinion ==1)||(opinion ==-1))){
                        System.out.print("sen"+sentence+" ");
                        return opinion;
                    }
                    opinion =0;
                }
            }
        }



// your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)
        return 0;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

//String review = "Sorry OG, but you just lost some loyal
//        customers. Horrible service, no smile or greeting just attitude. The
//        breadsticks were stale and burnt, appetizer was cold and the food came
//        out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
        };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible",
                "awful", "unprofessional", "poor" };

        SentimentAnalyzer obj1 = new SentimentAnalyzer(featureSet,posOpinionWords,negOpinionWords,review);

        System.out.println(review);

        int[] featureOpinions = obj1.detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);

        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    } }