//The SequenceHandler is the piece of code that defines the sequence of events
//that constitute the experiment.
//
//SequenceHandler.Next() will run the next step in the sequence.
//
//We can also switch between the main sequence of events and a subsequence
//using the SequenceHandler.SetLoop command. This takes two inputs:
//The first sets which loop we are in. 0 is the main loop. 1 is the first
//subloop. 2 is the second subloop, and so on.
//
//The second input is a Boolean. If this is set to true we initialise the 
//position so that the sequence will start from the beginning. If it is
//set to false, we will continue from whichever position we were currently in.
//
//So SequenceHandler.SetLoop(1,true) will switch to the first subloop,
//starting from the beginning.
//
//SequenceHandler.SetLoop(0,false) will switch to the main loop,
//continuing from where we left off.

package com.sam.webtasks.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.sam.webtasks.basictools.CheckIdExists;
import com.sam.webtasks.basictools.CheckScreenSize;
import com.sam.webtasks.basictools.ClickPage;
import com.sam.webtasks.basictools.Consent;
import com.sam.webtasks.basictools.Counterbalance;
import com.sam.webtasks.basictools.InfoSheet;
import com.sam.webtasks.basictools.Initialise;
import com.sam.webtasks.basictools.Names;
import com.sam.webtasks.basictools.PHP;
import com.sam.webtasks.basictools.ProgressBar;
import com.sam.webtasks.basictools.Slider;
import com.sam.webtasks.basictools.TimeStamp;
import com.sam.webtasks.iotask1.IOtask1Block;
import com.sam.webtasks.iotask1.IOtask1BlockContext;
import com.sam.webtasks.iotask1.IOtask1DisplayParams;
import com.sam.webtasks.iotask1.IOtask1InitialiseTrial;
import com.sam.webtasks.iotask1.IOtask1RunTrial;



public class SequenceHandler {
	public static void Next() {	
		// move forward one step in whichever loop we are now in
		sequencePosition.set(whichLoop, sequencePosition.get(whichLoop) + 1);

		switch (whichLoop) {
		case 0: // MAIN LOOP
			switch (sequencePosition.get(0)) {
			/***********************************************************************
			 * The code here defines the main sequence of events in the experiment *
			 ********************************************************************/			
			case 1:
				ClickPage.Run(Instructions.Get(0), "Continuez");
				break;
			case 2:
				//practice 1: 6 circles, no targets
				IOtask1Block block1 = new IOtask1Block();
				block1.blockNum = 1;
				block1.nCircles = 6;
				block1.nTrials = 1;
				block1.nTargets = 0;
				block1.askArithmetic = false;
				block1.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block1.Run();
				break;
			case 3:
				ClickPage.Run(Instructions.Get(1), "Continuez");
				break;
			case 4:
				//practice 2: 10 circles, no targets
				IOtask1Block block2 = new IOtask1Block();
				block2.blockNum = 2;
				block2.nTrials = 1;
				block2.nTargets = 0;
				block2.askArithmetic = false;
				block2.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block2.Run();
				break;
			case 5:
				ClickPage.Run(Instructions.Get(2), "Continuez");
				break;
			case 6:
				//practice 3: 10 circles, 1 target
				IOtask1Block block3 = new IOtask1Block();
				block3.blockNum = 3;
				block3.nTrials = 1;
				block3.nTargets = 1;
				block3.askArithmetic = false;
				block3.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block3.Run();				
				break;
			case 7:
				ClickPage.Run(Instructions.Get(4), "Continuez");
				break;
			case 8:
				//practice 4: 10 circles, 1 target with interruption
				IOtask1Block block4 = new IOtask1Block();
				block4.blockNum = 4;
				block4.nTrials = 1;
				block4.nTargets = 1;
				block4.askArithmetic = true;
				block4.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block4.Run();
				break;				
			case 9:
				// Metacognitive Judgement unaided memory 1 target
				Slider.Run("Maintenant que vous avez eu un peu de pratique avec l'expérience, nous aimerions que vous nous disiez "
						+ "avec quelle précision vous pouvez effectuer la tâche. Veuillez ignorer les essais précédents et "
						+ "dites-nous simplement avec quelle précision vous pouvez effectuer la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec un cercle spécial à retenir. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "de cercles spéciaux que vous pouvez faire glisser correctement vers le côté indiqué du carré, en moyenne. "
						+ "100% signifierait que vous obtenez toujours toutes les bonnes réponses. 0% signifierait que vous ne pouvez "
						+ "jamais en avoir un seul de correct. ", "Jamais", "Toujours");
				break;
			case 10:
				//save the selected slider value to the database 
				PHP.logData("slider_meta_unaided_1",  "" + Slider.getSliderValue(), true);
				break;
			case 11:
				// Effort judgement unaided memory 1 target
				Slider.Run("Maintenant que vous avez eu un peu de pratique avec l'expérience, nous aimerions que vous nous disiez "
						+ "quelle quantité d'effort vous aller investir pour réaliser la tâche. Veuillez ignorer les essais précédents et "
						+ "dites-nous simplement la quantité d’effort que vous allez déployer pour accomplir la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec un cercle spécial à retenir. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "d’effort déployer pour l’essai en moyenne. "
						+ "100% signifierait que l'essai vous a demandé un maximum d'effort. 0% signifierait que l'essai ne vous a "
						+ "demandé aucun effort."
						, "Aucun effort", "Maximum d'effort");
				break;
			case 12:
				PHP.logData("slider_effort_unaided_1", "" + Slider.getSliderValue(), true);
				break;
			case 13:
				ClickPage.Run(Instructions.Get(3), "Continuez");
				break;
			case 14:
				//practice 5: 10 circles, 3 targets with interruption
				IOtask1Block block5 = new IOtask1Block();
				block5.blockNum = 5;
				block5.nTrials = 1;
				block5.nTargets = 3;
				block5.askArithmetic = true;
				block5.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block5.Run();
				break;				
			case 15:
				// Metacognitive Judgement unaided memory 3 targets
				Slider.Run("S'il vous plaît, ignorez les essais pratiques précédents et "
						+ "dites-nous simplement avec quelle précision vous pouvez effectuer la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec trois cercles spéciaux à retenir. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "de cercles spéciaux que vous pouvez faire glisser correctement vers le côté indiqué du carré, en moyenne. "
						+ "100% signifierait que vous obtenez toujours toutes les bonnes réponses. 0% signifierait que vous ne pouvez "
						+ "jamais en avoir un seul de correct. ", "Jamais", "Toujours");
				break;
			case 16:
				//save the selected slider value to the database
				PHP.logData("slider_meta_unaided_3",  "" + Slider.getSliderValue(), true);
				break;
			case 17:
				// Effort judgement unaided memory 3 targets
				Slider.Run("S'il vous plaît, ignorez les essais pratiques précédents et "
						+ "quelle quantité d'effort vous aller investir pour réaliser la tâche. Veuillez ignorer les essais précédents et "
						+ "dites-nous simplement la quantité d’effort que vous allez déployer pour accomplir la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec trois cercles spéciaux à retenir. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "d’effort déployer pour l’essai en moyenne. "
						+ "100% signifierait que l'essai vous a demandé un maximum d'effort. 0% signifierait que l'essai ne vous a "
						+ "demandé aucun effort."
						, "Aucun effort", "Maximum d'effort");
				break;
			case 18:
				PHP.logData("slider_effort_unaided_3", "" + Slider.getSliderValue(), true);
				break;
			case 19:
				ClickPage.Run(Instructions.Get(5), "Continuez");
				break;
			case 20:
				//practice 6: 10 circles, 1 target, optional reminders
				IOtask1Block block6 = new IOtask1Block();
				block6.blockNum = 6;
				block6.nTrials = 1;
				block6.nTargets = 1;
				block6.askArithmetic = true;
				block6.offloadCondition = Names.REMINDERS_OPTIONAL;	
				block6.Run();
				break;
			case 21:
				// Metacognitive Judgement optional reminders 1 target
				Slider.Run("S'il vous plaît, ignorez les essais pratiques précédents et "
						+ "dites-nous simplement avec quelle précision vous pouvez effectuer la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec un cercle spécial à retenir et l'option "
						+ "pour définir des rappels en les faisant glisser vers le bord de la boîte. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "de cercles spéciaux que vous pouvez faire glisser correctement vers le côté indiqué du carré, en moyenne. "
						+ "100% signifierait que vous obtenez toujours toutes les bonnes réponses. 0% signifierait que vous ne pouvez "
						+ "jamais en avoir un seul de correct. ", "Jamais", "Toujours");
				break;
			case 22:
				//save the selected slider value to the database
				PHP.logData("slider_meta_reminder_1",  "" + Slider.getSliderValue(), true);
				break;
			case 23:
				// Effort judgement optional reminders 1 target
				Slider.Run("S'il vous plaît, ignorez les essais pratiques précédents et "
						+ "quelle quantité d'effort vous aller investir pour réaliser la tâche. Veuillez ignorer les essais précédents et "
						+ "dites-nous simplement la quantité d’effort que vous allez déployer pour accomplir la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec un cercle spécial à retenir et l'option "
						+ "pour définir des rappels en les faisant glisser vers le bord de la boîte. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "d’effort déployer pour l’essai en moyenne. "
						+ "100% signifierait que l'essai vous a demandé un maximum d'effort. 0% signifierait que l'essai ne vous a "
						+ "demandé aucun effort."
						, "Aucun effort", "Maximum d'effort");
				break;
			case 24:
				PHP.logData("slider_effort_reminder_1", "" + Slider.getSliderValue(), true);
				break;
			case 25:
				ClickPage.Run(Instructions.Get(3), "Continuez");
				break;
			case 26:
				//practice 7: 10 circles, 3 targets, optional reminders
				IOtask1Block block7 = new IOtask1Block();
				block7.blockNum = 7;
				block7.nTrials = 1;
				block7.nTargets = 3;
				block7.askArithmetic = true;
				block7.offloadCondition = Names.REMINDERS_OPTIONAL;	
				block7.Run();
				break;
			case 27:
				// Metacognitive Judgement optional reminders 3 targets
				Slider.Run("S'il vous plaît, ignorez les essais pratiques précédents et "
						+ "dites-nous simplement avec quelle précision vous pouvez effectuer la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec trois cercles spéciaux à retenir et la possibilité "
						+ "pour définir des rappels en les faisant glisser vers le bord de la boîte. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "de cercles spéciaux que vous pouvez faire glisser correctement vers le côté indiqué du carré, en moyenne. "
						+ "100% signifierait que vous obtenez toujours toutes les bonnes réponses. 0% signifierait que vous ne pouvez "
						+ "never get any of them correct. ", "Jamais", "Toujours");
				break;
			case 28:
				//save the selected slider value to the database
				PHP.logData("slider_meta_reminder_3",  "" + Slider.getSliderValue(), true);
				break;
			case 29:
				Slider.Run("S'il vous plaît, ignorez les essais pratiques précédents et "
						+ "quelle quantité d'effort vous aller investir pour réaliser la tâche. Veuillez ignorer les essais précédents et "
						+ "dites-nous simplement la quantité d’effort que vous allez déployer pour accomplir la tâche lorsqu'elle présente la même difficulté que "
						+ "l'essai que vous venez de terminer, avec trois cercles spéciaux à retenir et l'option "
						+ "pour définir des rappels en les faisant glisser vers le bord de la boîte. <br><br>"
						+ "Veuillez utiliser l'échelle ci-dessous pour indiquer le pourcentage "
						+ "d’effort déployer pour l’essai en moyenne. "
						+ "100% signifierait que l'essai vous a demandé un maximum d'effort. 0% signifierait que l'essai ne vous a "
						+ "demandé aucun effort."
						, "Aucun effort", "Maximum d'effort");
				break;
			case 30:
				PHP.logData("slider_effort_reminder_3", "" + Slider.getSliderValue(), true);
				break;
			case 31:
				//instructions phase 1
				
				//Window.alert("test");

				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_SECOND){
					ClickPage.Run(Instructions.Get(7), "Continuez");
				}
				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_FIRST){
					ClickPage.Run(Instructions.Get(6), "Continuez");
				}
				
				break;				
			case 32:
				//phase 1
				IOtask1Block block8 = new IOtask1Block();
				block8.blockNum = 8;
				block8.nTrials = 10;
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);
				block8.targetList.add(3);				
				block8.askArithmetic = true;
				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_SECOND) {
					block8.offloadCondition = Names.REMINDERS_NOTALLOWED;}
				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_FIRST) {
					block8.offloadCondition = Names.REMINDERS_OPTIONAL;}
				block8.Run();
				break;
			case 33:
				//instructions phase 2
				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_SECOND) {
					ClickPage.Run(Instructions.Get(9), "Continuez");
				}
				
				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_FIRST) {
					ClickPage.Run(Instructions.Get(8), "Continuez");
				}
				break;
			case 34:
				//phase 2
				IOtask1Block block9 = new IOtask1Block();
				block9.blockNum = 9;
				block9.nTrials = 10;
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.targetList.add(3);
				block9.askArithmetic = true;
				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_SECOND) {
					block9.offloadCondition = Names.REMINDERS_OPTIONAL;}
				if (Counterbalance.getFactorLevel("conditionOrder") == ExtraNames.OFFLOAD_FIRST) {
					block9.offloadCondition = Names.REMINDERS_NOTALLOWED;}
				block9.Run();
				break;
			case 35:
				// log data and check that it saves
				String data = Counterbalance.getFactorLevel("conditionOrder") + ",";
				data = data + SessionInfo.gender + ",";
				data = data + SessionInfo.age + ",";
				data = data + TimeStamp.Now();

				PHP.logData("finish", data, true);
				break;
			case 36:
				// complete the experiment
				Finish.Run();
				break;
			}
			break;
		

		/********************************************/
		/* no need to edit the code below this line */
		/********************************************/

		case 1: // initialisation loop
			switch (sequencePosition.get(1)) {
			case 1:
				// initialise experiment settings
				Initialise.Run();
				break;
			case 2:
				// make sure that a participant ID has been registered.
				// If not, the participant may not have accepted the HIT
				CheckIdExists.Run();
				break;
			case 3:
				// check the status of this participant ID.
				// have they already accessed or completed the experiment? if so,
				// we may want to block them, depending on the setting of
				// SessionInfo.eligibility
				PHP.CheckStatus();
				break;
			case 4:
				// check whether this participant ID has been used to access a previous experiment
				PHP.CheckStatusPrevExp();
				break;
			case 5:
				// clear screen, now that initial checks have been done
				RootPanel.get().clear();

				// make sure the browser window is big enough
				CheckScreenSize.Run(SessionInfo.minScreenSize, SessionInfo.minScreenSize);
				break;
			case 6:
				if (SessionInfo.runInfoConsentPages) { 
					InfoSheet.Run(Instructions.InfoText());
				} else {
					SequenceHandler.Next();
				}
				break;
			case 7:
				if (SessionInfo.runInfoConsentPages) { 
					Consent.Run();
				} else {
					SequenceHandler.Next();
				}
				break;
			case 8:
				SequenceHandler.SetLoop(0, true); // switch to and initialise the main loop
				SequenceHandler.Next(); // start the loop
				break;
			}
			break;
			
		case 2: // IOtask1 loop
			switch (sequencePosition.get(2)) {
			/*************************************************************
			 * The code here defines the sequence of events in subloop 2 *
			 * This runs a single trial of IOtask1                       *
			 *************************************************************/
			case 1:
				// first check if the block has ended. If so return control to the main sequence
				// handler
				IOtask1Block block = IOtask1BlockContext.getContext();

				if (block.currentTrial == block.nTrials) {
					SequenceHandler.SetLoop(0, false);
				}

				SequenceHandler.Next();
				break;
			case 2:
				// now initialise trial and present instructions
				IOtask1InitialiseTrial.Run();
				break;
			case 3:
				// now run the trial
				IOtask1RunTrial.Run();
				break;
			case 4:
				// log end of trial
				PHP.logData("trialEnd",  IOtask1BlockContext.getContext().blockNum + ", " + IOtask1BlockContext.getContext().currentTrial, true);
				break; 
			case 5:
				// we have reached the end, so we need to restart the loop
				SequenceHandler.SetLoop(2, true);
				SequenceHandler.Next();
				break;
				// TODO: mechanism to give post-trial feedback?
				
			}
		
		}
	}
	
	private static ArrayList<Integer> sequencePosition = new ArrayList<Integer>();
	private static int whichLoop;

	public static void SetLoop(int loop, Boolean init) {
		whichLoop = loop;

		while (whichLoop + 1 > sequencePosition.size()) { // is this a new loop?
			// if so, initialise the position in this loop to zero
			sequencePosition.add(0);
		}

		if (init) { // go the beginning of the sequence if init is true
			sequencePosition.set(whichLoop, 0);
		}
	}

	// set a new position
	public static void SetPosition(int newPosition) {
		sequencePosition.set(whichLoop, newPosition);
	}
	
	// get current loop
	public static int GetLoop() {
		return (whichLoop);
	}

	// get current position
	public static int GetPosition() {
		return (sequencePosition.get(whichLoop));
	}
}
