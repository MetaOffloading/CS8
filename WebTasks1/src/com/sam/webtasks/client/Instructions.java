package com.sam.webtasks.client;

import com.sam.webtasks.basictools.Counterbalance;

public class Instructions {

	public static String Get(int index) {
		String i = "";

		switch (index) {
		case 0:
			i = "In this experiment you will have a simple task to do.<br><br>"
					+ "You will see several yellow circles inside a box. Inside each circle will be a number. <br><br>"
					+ "You can move them around with your finger. Your task is to drag them to the bottom of the box in sequence.<br><br>"
					+ " Please start by dragging 1 all the way to the bottom. This will make it disappear. <br><br>"
					+ "Then drag 2 to the bottom, then 3, and so on.";
			break;

		case 1:
			i="Now you will continue the task with more circles on the screen. ";
			break;
			
		case 2:
			i="Now you will continue the same task, but sometimes there will be something else to do. <br><br>"
					+ "As well as dragging each circle in turn to the "
					+ "bottom of the screen, you will be instructed to drag one or more "
					+ "of the circles to another part of the box. For instance, you might be told that you should drag number 5 "
					+ "to the left of the box instead of the bottom.<br><br>"
					+ "You will still be able to drag any circle to the bottom of the box, but you should try to "
					+ "remember to drag these special circles to the instructed location. ";
			break;

		case 3:
			i="Now you will do the task again, but this time there will be three special circles to remember.";
			break;
			
		case 4:
			i="Now you will continue with the same task, but sometimes you will be interrupted by "
					+"an arithmetic question. You will need to answer the question in order to continue the other task.";
			break;
			
		case 5:
			i="Some people find it helpful to drag "
					+ "the special circles near to the edge of the box to help them remember.<br><br> "
					+ "For example, if you had to remember to drag 5 to the left of the box, "
					+ "you could drag it near to there at the beginning, before you drag the 1. "
					+ "Then when you eventually got to 5, its location would remind you "
					+ "what to do. You should feel free to use this strategy if you like, but "
					+ "it's up to you.<br><br> "
					+ "Click below to continue.";
			break;
			
		case 6:
			i = "Now the experiment will start for real.<br><br> "
					+ "You can choose whether to use the strategy of placing the special circles "
					+ "at the edge of the box as reminders or just use your own memory without setting any reminders.<br><br>"
					+ "You should feel free to do the task however you prefer. It's completely up to you.<br><br> "
					+ "Please click below to continue. ";
			break;
			
		case 7:
			i = "Now the experiment will start for real.<br><br> "
					+ "For this part of the experiment, you will have to use your own memory to do the task. "
					+ "You will not be able to place the special circles at the edge of the box as reminders. "
					+ "Just use your own memory and try your best.<br><br> "
					+ "Please click below to continue. ";
			break;
			
		case 8:
			i = "From this point onwards you will not be able to place special circles at the edge of the box as reminders.<br><br>"
					+ "Just use your own memory and try your best.<br><br> "
					+ "Please click below to continue. ";
			break;
			
		case 9:
			i="For the rest of the experiment, it will be up to you whether to set reminders or not. That is, "
					+ "you can choose whether to use the strategy of placing the special circles "
					+ "at the edge of the box as reminders or just use your own memory without setting any reminders.<br><br>"
					+ "You should feel free to do the task however you prefer. It's completely up to you.<br><br> "
					+ "Please click below to continue. ";
			break;
			
		case 10:
			i="TEST ";
			break;
		}

		return (i);
	}

	public static String InfoText() {
		return ("We would like to invite you to participate in this research project. "
				+ "You should only participate if you want to; choosing not to take part "
				+ "will not disadvantage you in any way. Before you decide whether you "
				+ "want to take part, please read the following information carefully and "
				+ "discuss it with others if you wish. Ask us if there is anything that "
				+ "is not clear or you would like more information.<br><br>"
				+ "We are recruiting volunteers from the Amazon Mechanical Turk website to "
				+ "take part in an experiment aiming to improve our understanding of human "
				+ "attention and memory. Full instructions will be provided before the experiment begins. "
				+ "The experiment " + "will last approximately 40 minutes. There are no anticipated risks or "
				+ "benefits associated with participation in this study.<br><br>"
				+ "It is up to you to decide whether or not to take part. If you choose "
				+ "not to participate, you won't incur any penalties or lose any "
				+ "benefits to which you might have been entitled. However, if you do "
				+ "decide to take part, you can print out this information sheet and "
				+ "you will be asked to fill out a consent form on the next page. " + "Even after agreeing to take "
				+ "part, you can still withdraw at any time and without giving a reason. "
				+ "<br><br>All data will be collected and stored in accordance with the UK Data "
				+ "Protection Act 1998.");
	}

}
