package org.moeaframework.problem.misc;

import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.RealVariable;
import org.moeaframework.problem.AbstractProblem;

/**
 * The Laumanns problem.
 * <p>
 * Properties:
 * <ul>
 *   <li>Disconnected Pareto set
 *   <li>Convex Pareto front
 * </ul>
 * <p>
 * References:
 * <ol>
 *   <li>Van Veldhuizen, D. A (1999).  "Multiobjective Evolutionary Algorithms: 
 *       Classifications, Analyses, and New Innovations."  Air Force Institute
 *       of Technology, Ph.D. Thesis, Appendix B.
 * </ol>
 */
public class Laumanns extends AbstractProblem {

	public Laumanns() {
		super(2, 2);
	}

	@Override
	public void evaluate(Solution solution) {
		double x = ((RealVariable)solution.getVariable(0)).getValue();
		double y = ((RealVariable)solution.getVariable(1)).getValue();
		double f1 = Math.pow(x, 2.0) + Math.pow(y, 2.0);
		double f2 = Math.pow(x+2.0, 2.0) + Math.pow(y, 2.0);
		
		solution.setObjective(0, f1);
		solution.setObjective(1, f2);
	}

	@Override
	public Solution newSolution() {
		Solution solution = new Solution(2, 2);
		
		solution.setVariable(0, new RealVariable(-50.0, 50.0));
		solution.setVariable(1, new RealVariable(-50.0, 50.0));
		
		return solution;
	}

}
