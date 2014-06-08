/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ken O'Neill 2014
 *
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.eeikonl.weasel;

import static com.eeikonl.weasel.Language.*;

import java.util.*;

public class Weasel {
    private final String phrase = "Monster Play is unlocked when a player's character reaches level 10; players can then play a level 95 monster. Only one type of monster player is available for free players; others can be purchased individually, or completely unlocked by purchasing a subscription. These monster players (also known as creeps) have their own quests, titles and deeds, and fight the Heroes (player characters of level 90 and above, and known as freeps, a portmanteau of the words \"Free Peoples\") in the Ettenmoors. Both heroes and monsters fight for the control of various keeps in the Ettenmoors, of which 5 are able to be taken. When one side holds two outposts (after a period of time the outpost will return to the NPC forces), they are able to go into the Delving of Fror, a dungeon area beneath the Ettenmoors. Outposts are smaller versions of keeps and require fewer people to overtake. As of the expansion Mines of Moria and Siege of Mirkwood the amount of outposts required to enter the Delving of Fror has dropped to two, so that both the freeps and creeps can enter the delving of Fror simultaneously (5 outposts overall, 2 required to enter). Both monster players and Heroes gain ranks in the Ettenmoors through defeating the opposing side. Monsters receive infamy for killing a Hero, and Heroes receive renown for killing a monster player. There are 15 achievable ranks, starting at Footman, and ending at Captain-General (for Heroes) or starting at Tracker and ending at Tyrant (for monster players). Gaining ranks allows the player to purchase specific equipment and armour (for Heroes) or core upgrades, like health, armor and power (for Monsters). Another aspect of PvMP is commendations. Both Heroes and monster players receive commendations for completing quests or defeating an enemy player. Commendations can be used by monster players to buy various background statistic improvements, skills and appearances. Heroes can use commendations to buy special PvMP rank armour and background statistic improvements. Many players rely on raids or groups to gain Infamy or Renown for their character. In a raid or group the points gained are divided between the different members, so while killing more quickly each player will gain less per kill. Often during a raid there will be one leader who gives directions to the rest of the raid over a voice program or the in-game voice application. Raids are most commonly found on larger servers, but exist on all servers. While most players gain Infamy or Renown on their respective side through killing enemy players through small skirmishes, healing friendly players also contributes Renown or Infamy to the player. The higher ranks in the game are noted to take a period of months to years of consistent gaming to achieve. This lengthy time to achieve higher ranks is derived from the fact that the total Infamy or Renown amount required for achieving higher ranks rises exponentially with every rank achieved. The best example of this is: rank 6 requires a total of 35,500 Renown, however, rank 7 requires a total of 71,000 which is over twice the total to achieve rank 6.[10] The concept of rank farming is an alternative route some players choose to use in order to accelerate the ranking process to faster access equipment and rank promotion buffs within the Ettenmoors that have a minimum rank requirement, though it is no longer allowed and considered an abuse of game mechanics.[11] This concept is not unique to LOTRO and is seen in other games of the same genre. Most of this activity in LOTRO is achieved through the use of multiboxing with several copies of the game client run to utilise a multitude of reaver monster play characters. The reaver class went free-to-play early 2012 and has since most often been used in this type of play. Rank farming has had notable impact upon the PvP gaming community. An official statement released on August 28, 2013 by Turbine customer service has made rank farming a bannable offense.[11] While the issue of fairness and sportsmanship has been raised for this style of play, Turbine has officially supported the multiboxing community in its official statements to date.[12]";

    public static void main(final String[] args) {
        new Weasel().start();
    }

    private void start() {
        checkAllCharactersAreValid(phrase);
        findMatchingPhrase();
    }

    private void findMatchingPhrase() {
        int iteration = 0;
        String nextSuggestion = "";
        do {
            nextSuggestion = getNextSuggestion(nextSuggestion);
            iteration++;
        } while (!phrase.equals(nextSuggestion));
        System.out.printf("Solution found after %d iterations%n", iteration);
    }

    private String getNextSuggestion(final String lastSuggestion) {
        String suggestion = "";
        int score = 0;
        for (int x = 0; x < 100; x++) {
            final String nextResult = getRandomString(lastSuggestion);
            final int size = getScore(nextResult).size();
            if (size > score) {
                score = size;
                suggestion = nextResult;
            }
        }
        System.out.printf("Wanted Phrase:\t%s%nSuggestion:\t%s%nScore\t%d%n", phrase, suggestion, score);
        return suggestion;
    }

    private String getRandomString(final String lastSuggestion) {
        final Set<Integer> correctLetters = getScore(lastSuggestion);
        String suggestion = "";
        final Random random = new Random();
        for (int x = 0; x < phrase.length(); x++) {
            if (!correctLetters.contains(x)) {
                suggestion += alphabet[random.nextInt(alphabet.length)];
            } else {
                suggestion += lastSuggestion.charAt(x);
            }
        }
        return suggestion;
    }

    private Set<Integer> getScore(final String suggestion) {
        final Set<Integer> correctLetters = new HashSet<Integer>();
        if (suggestion.equals("")) {
            return correctLetters;
        }
        for (int x = 0; x < phrase.length(); x++) {
            if (phrase.charAt(x) == suggestion.charAt(x)) {
                correctLetters.add(x);
            }
        }
        return correctLetters;
    }
}
