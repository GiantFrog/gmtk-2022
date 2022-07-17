package science.skywhale.bloodmortgage;

import java.util.HashMap;

public class Dialogs
{
	public static String addLineBreaks(String str)
	{
		return addLineBreaks(str, 40);
	}
	public static String addLineBreaks(String str, int lineLength) {
		int lenStr = str.length();
		String newStr = "";
		int endIndex = lineLength;
		int startIndex = 0;
		while (startIndex < lenStr){
			String newSub = str.substring(startIndex, endIndex);
			int lastSpace = newSub.lastIndexOf(" ");
			//System.out.println("Start: " + startIndex + " end: " + endIndex + " last: " + lastSpace);
			if (lastSpace > 0){
				endIndex = startIndex + lastSpace;
			}
			//giSystem.out.println("Start: " + startIndex + " end: " + endIndex);
			newSub = str.substring(startIndex, endIndex);
			newStr += newSub + "\n";
			
			if (lastSpace > 0){
				startIndex += newSub.length() + 1;
			} else {
				startIndex += lineLength;
			}
			endIndex += lineLength;
			if (endIndex > lenStr){
				endIndex = lenStr;
			}
		}
		return newStr;
	}
	static String [] chaeriDialogList = new String[]{"Move and press 'C' again to hear a new piece of advice!",
													 "When in the enchanting menu, you can hold Shift then type" +
													 "the letter of the Glyph and I’ll tell you what I know about it!",
													 "Some Glyphs increase your maximum HP " +
													 "permanently, giving you more breathing room in future fights.",
													 "There’s no penalty for losing a game of Die Fighting",
													 "Have you talked to that Matty Murky fellow? " +
													 "I think he’s an actor. So cool!",
													 "Increasing your maximum HP does " +
													 "not heal you for that amount.",
													 "Has nobody else noticed that the " +
													 "rock over there has eyes?",
													 "Be careful with those Blood Sacrifice Glyphs, the payout " +
													 "is huge but I hate seeing you hurt yourself.",
													 "I still miss her, but I’m glad she was " +
													 "able to pull off that whole birch stunt. " +
													 "Seeing her around makes me feel a bit more safe.",
													 "Hey! Have you heard? " +
													 "We get to DO stuff in the next update!",
													 "Heard they ran out of " +
													 "budget just before launch… rough.",
													 "Some Glyphs get stronger the more they are used, " +
													 "and the bonuses persist between games of Die Fighting.",
													 "Block glyphs prevent incoming damage " +
													 "from the opponent’s next turn.",
													 "Physically weighting your Die is illegal. But enchanting it " +
													 "so that one side is heavier is okay. Make it make sense!",
													 "I think I went on a date with one of those imps in high school. " +
													 "But I can’t remember if it was Scrungle or Scraggy.",
													 "I’m gonna say it! I don’t think a hut with chicken legs is " +
													 "that scary. But Baba Yaga herself is pretty nasty.",
													 "I’m glad you kept around that spellbook with all your " +
													 "glyphs from your days when you did this professionally. " +
													 "Even if it has some painful memories, it has " +
													 "certainly come in handy today.",
													 "Do you think the mice will rise as vampiric thralls? " +
													 "They look pretty dead to me…",
													 "I used all the confetti making a cake last week, " +
													 "that’s why the glyph doesn’t do anything. Sorry.",
													 "I suppose a Blood Mortgage would come from a " +
													 "blood bank, wouldn’t it. Popular with vampires, I’m told.",
													 "Don’t forget that you always start a " +
													 "game of Die Fighting at full health."};
	
	static String [] chaeri_npcDialogList = new String[] {"Oh Kal! This is awful! Whatever will we do?",
														  "I guess we should probably explore a bit, get a feel " +
														  "for our new surroundings. If you need anything from me, " +
														  "just call me with C for Chaeri!",
														  "I don’t like this place, it gives me the heebie-jeebies! " +
														  "We need to find a better solution than this box. Like, " +
														  "who’s that creep with the top hat over there?"};
	static String [] athdranaxDialogList = new String[] {"Well Howdy Doo-dee! You must be Kalthuzar the Grand! " +
														"I just saw you get kicked out on the street. " +
														"That’s a real shame.",
														"Now, Kal ol’ pal, I know this might be too soon," +
														" but can I interest you in a round of Die Fighting? " +
														"Word is you used to be quite the fiend yourself back " +
														"in Porte Lande, before your incident.",
														"Now that I think about it, this might be a perfect " +
														"opportunity for you, Kal the Wily. A little impy told " +
														"me that that old crone Baba Yaga is looking to " +
														"get rid of her legendary Hut.",
														"Apparently, she had to take a Blood Mortgage out, " +
														"and she’s having trouble keeping up with the " +
														"payments since the orphanage burned down.",
														"And it just so happens that she is the reigning " +
														"queen of the Die Fighting scene in your absence. " +
														"Maybe she’d be willing to part with her hut for " +
														"the chance to play against the old champ.",
														"Now what’s this? You don’t have a Die? " +
														"Here, you can use one of mine, I assure you, it’s " +
														"regulation! In exchange, you have to play a round with me.",
														"Go ahead and press Esc so you can enhance your die, " +
														"I’m sure you’ve still got some good Glyphs up " +
														"your sleeve. Then come over here and let’s have " +
														"a grand old time or Die Fighting!"};
	static String [] randDialogLIst = new String[] {"It’s just a rock. With eyes. Not that unusual, all things " +
													"considered. A rock with eyes might unsettle some people, but its " +
													"gaze makes you feel strangely safe.",
													"You look around, nobody else is in this corner of the park. You " +
													"feel silly but you say “Hello” to the rock.",
													"Out of nowhere, you start gushing your feelings to the rock. These " +
													"past few days have been so hard, with the eviction and all. The " +
													"rock’s eyes are trained on you.",
													"You come back for another therapy session with the rock. Then " +
													"suddenly you hear a voice: Hey man I feel bad for you, but can you " +
													"go find a non-sentient rock to bother?"};
	static String [] mattyDialogList = new String [] {"Me? Oh no. I don’t partake in Die Fighting. It’s not that I’m " +
													  "critical, I just prefer more immersive games.",
													  "What’s your name? Kalthuzar the Eternal? That Kalthuzar? Of " +
													  "course I’ve heard about you! Hey, not to sound like a critic, " +
													  "but If I were you, I’d be worried about going up against Baba " +
													  "Yaga, she runs this town.",
													  "Sometimes I feel like we’re all just playing out a role, not " +
													  "knowing how it’ll end.",
													  "What do you think of my new Rolls Doice? It has a d8 engine.",
													  "Not that anyone asked, but I think Die Fighting would be more " +
													  "interesting if you had more types of dice. The d6 is classic, " +
													  "sure, but it’s not the most satisfying roll."};
	static String [] birchDialogList = new String [] {"I think this is my favorite time of year. I find great joy and" +
													  " enrichment, both mentally and physically, when I can provide " +
													  "this garden with some shade from my leaves.",
													  "I’m glad to see you again Kal. I would have come visit you, you " +
													  "know. Even after what happened. But as you can see, I’m kinda " +
													  "rooted in place here. Sorry, just a bit of tree humor.",
													  "I’m surprised at how quickly my trunk is thickening, it must be " +
													  "a result of the spell. Before long you won’t be able to wrap " +
													  "your arms all the way around me! And I’m proud to say that " +
													  "that doesn’t bother me any more.",
													  "I still love you Kal. Of course I’m disappointed with how " +
													  "things turned out, but I am learning to live with it. I’m just " +
													  "thankful we can still have moments like this, just you and me. " +
													  "Promise me you’ll visit more often, please?"};
	static String [] hutDialogList = new String [] {"You hear the scream of a child abruptly cut off as you approach " +
													"the swampy ground where the Hut of Baba Yaga currently nests. It " +
													"is much more intimidating when you’re this close. A voice calls out:",
													"Ahhh ah ah…tsk! Unless my eyes deceive me? That must be Kalthuzar " +
													"the Undying! I thought that must have been what happened when you " +
													"disappeared after the… incident.",
													"Athdranax has already told me about your eviction.Sorry to hear " +
													"about that. I’m sick of having to pay these monthly Blood " +
													"Mortgages myself, and the hut has started getting snappy with me " +
													"lately. But still it is a roof over my head, so I can’t complain.",
													"All that said, I would be willing to put ownership ol’ chicky " +
													"legs here on the line just to play a game against Kalthuzar the " +
													"Indomitable. Everyone in town still compares me to you, you know. " +
													"And by putting you down, I’ll finally prove I am the Die Fighter " +
													"in the tri-county area!",
													};
	
	static HashMap<String, String[]> allDialogs = new HashMap<>() {{
		put("Chaeri", chaeriDialogList);
		put("Athdranax", athdranaxDialogList);
		put("Rand the Rock", randDialogLIst);
		put("the Hut of Baba Yaga", hutDialogList);
		put("Matty Murky", mattyDialogList);
		put("Chaeri_NPC", chaeri_npcDialogList);
		put("Magnificent Birch", birchDialogList);
	}};
}
