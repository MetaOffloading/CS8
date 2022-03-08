//this code set up a trial by determining the targets (if any), then presents the instructions for that trial
package com.sam.webtasks.iotask1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.google.gwt.user.client.Random;
import com.sam.webtasks.basictools.ClickPage;

public class IOtask1InitialiseTrial {
	public static void Run() {
		IOtask1Block block = IOtask1BlockContext.getContext();		
		 
		//reset the list of offloaded circles, so that offloading on one trial is not counted towards the next
		block.notYetOffloaded.clear();
		block.allOffloaded.clear();
		 
		//reset the targetCircles
		block.targetCircles[0] = 0;
		block.targetCircles[1] = -10;
		block.targetCircles[2] = -10;
		block.targetCircles[3] = -10;
		block.targetCircles[4] = -10;
				
		//set default exit
		block.targetCircles[block.defaultExit] = -1;
		
		//start setting up instructions
		String instructions = "Faites glisser les chiffres dans l'ordre au bas de la boîte<br>"
				+ "(1, 2, 3, 4, etc.)<br><br>";
		
		//start setting up possible target sides (LEFT, RIGHT, etc.)
		ArrayList<Integer> possibleTargetSides = new ArrayList<Integer>();
		
		for (int i = 1; i < 5; i++) {
			if (i != block.defaultExit) {
				possibleTargetSides.add(i);
			}
		}
		
		//shuffle possible target positions
		for (int i = 0; i < possibleTargetSides.size(); i++) {
			Collections.swap(possibleTargetSides,  i,  Random.nextInt(possibleTargetSides.size()));
		}
		
		//now set up possible positions in the sequence (1 ... nCircles) for targets
		ArrayList<Integer> targetSeqPositions = new ArrayList<Integer>();
		
		for (int i = 2; i < block.nCircles; i++) { //start at i=2 so that first possible target is on third circle
			targetSeqPositions.add(i);
		}
		
		//shuffle possible target positions
		for (int i = 0; i < targetSeqPositions.size(); i++) {
			Collections.swap(targetSeqPositions, i, Random.nextInt(targetSeqPositions.size()));
		}
		
		//get number of targets on this trial
		int nTargets=block.targetList.get(block.currentTrial);
		
		if (nTargets>0) { 
			//get target positions
			ArrayList<Integer> targetSeqPositionsSorted = new ArrayList<Integer>();
			
			for (int i = 0; i < nTargets; i++) {
				targetSeqPositionsSorted.add(targetSeqPositions.get(i));
			}
			
			//put them in ascending order
			Collections.sort(targetSeqPositionsSorted);
			
			if (block.askArithmetic) {
				//select a random position before the first target circle
				block.quizCircle = Random.nextInt(targetSeqPositionsSorted.get(0));
			}
			
			//add additional instructions for targets
			instructions = instructions + "MAIS:<br><br>";
			
			for (int i = 0; i < nTargets; i++) {
				int exitSide = possibleTargetSides.get(0);
				possibleTargetSides.remove(0);
				
				String exitText = "";
				
				switch (exitSide) {
				case 1:
					exitText="la GAUCHE";
					break;
				case 2:
					exitText="la DROITE";
					break;
				case 3:
					exitText="le EN HAUT";
					break;
				case 4:
					exitText="EN BAS";
				    break;
				}
				
				int targetSeqPosition = targetSeqPositionsSorted.get(0);
				targetSeqPositionsSorted.remove(0);
				
				block.targetCircles[exitSide] = targetSeqPosition;
				block.notYetOffloaded.add(targetSeqPosition);
				
				instructions = instructions + "S'il vous plaît, faites glisser " + (targetSeqPosition+1) + " vers ";
				instructions = instructions + exitText + " à la place.<br>";
			}
		}
		
		//set a timestamp for the presentation of the instructions. we can measure the reading time from this starting point
		block.instructionStart = new Date();

		//save the block context
		IOtask1BlockContext.setContext(block);
		
		ClickPage.Run(instructions,  "Continuez");
	}
}
