///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           Draws a text frame based on a constant value.
//Course:          CS 200, Fall 2019
//
//Author:          Benjamin Fan
//Email:           bfan@cs.wisc.edu or byfan@wisc.edu
//Lecturer's Name: Marc R Lec 3
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// 
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////


public class CondMazeLab extends Maze 
{

	public static void main(String[] args) { 

		// Step 1: Run Maze Simulation
		CondMazeLab myMaze = new CondMazeLab();


	}

	public void step() 
	{   
		// Steps 2 and 3: Implement HERE
		bruteForceAlg();
		handleObstacle();
		puss.forward();
	}

	/**
	 * bad brute force algorithm, originally was going to use a fake "heap" for astar
	 *
	 */
	private void bruteForceAlg() {
		puss.left();
		if (puss.isFacingWall()) {
			puss.right();
		} if (puss.isFacingWall()) {
			puss.right();
		}


	}

	private void handleObstacle() {
		while (puss.isFacingDog() || puss.isFacingGully() || puss.isFacingMud() || puss.isFacingWall()) {

			if (puss.isFacingMud())
			{
				if (puss.isTipToeing())
				{
					puss.stopTipToe();
				}
				puss.putOnBoots();
				puss.forward();
				bruteForceAlg();
			}
			if (puss.isFacingDog())
			{
				if (puss.isInBoots())
				{
					puss.takeOffBoots();
				}
				puss.startTipToe();
				puss.forward();
				bruteForceAlg();
			}

			if (puss.isFacingGully())
			{
				if (puss.isInBoots())
				{
					puss.takeOffBoots();
				}
				if (puss.isTipToeing())
				{
					puss.stopTipToe();
				}
				puss.jump();
				bruteForceAlg();
			}
			while(puss.isFacingWall()) {

				bruteForceAlg();
			}
		}
	}


	public CondMazeLab() { super(true); }
}