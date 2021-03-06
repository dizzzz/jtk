/****************************************************************************
Copyright (c) 2005, Colorado School of Mines and others. All rights reserved.
This program and accompanying materials are made available under the terms of
the Common Public License - v1.0, which accompanies this distribution, and is
available at http://www.eclipse.org/legal/cpl-v10.html
****************************************************************************/
package edu.mines.jtk.lapack;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import static edu.mines.jtk.lapack.DMatrixTest.assertEqualFuzzy;

/**
 * Tests {@link edu.mines.jtk.la.DMatrixEvd}.
 * @author Dave Hale, Colorado School of Mines
 * @version 2005.12.16
 */
public class DMatrixEvdTest extends TestCase {
  public static void main(String[] args) {
    TestSuite suite = new TestSuite(DMatrixEvdTest.class);
    junit.textui.TestRunner.run(suite);
  }

  public void testSymmetric() {
    DMatrix a = new DMatrix(new double[][]{
      {4,1,1},
      {1,2,3},
      {1,3,6}
    });
    test(a);
    a = DMatrix.random(10,10);
    a.plusEquals(a.transpose());
    test(a);
  }

  public void testAsymmetric() {
    DMatrix a = new DMatrix(new double[][]{
      {      0,       1,       0,     0},
      {      1,       0,  2.0e-7,     0},
      {      0, -2.0e-7,       0,     1},
      {      0,       0,       1,     0}
    });
    test(a);
    a = DMatrix.random(10,10);
    test(a);
  }

  private void test(DMatrix a) {
    DMatrixEvd evd = new DMatrixEvd(a);
    DMatrix d = evd.getD();
    DMatrix v = evd.getV();
    assertEqualFuzzy(a.times(v),v.times(d));
  }
}
