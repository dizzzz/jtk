/****************************************************************************
Copyright (c) 2004, Colorado School of Mines and others. All rights reserved.
This program and accompanying materials are made available under the terms of
the Common Public License - v1.0, which accompanies this distribution, and is
available at http://www.eclipse.org/legal/cpl-v10.html
****************************************************************************/
package edu.mines.jtk.sgl;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Tests all classes in package edu.mines.jtk.sgl.
 * @author Dave Hale
 * @version 2005.05.20
 */
public class AllTest extends TestSuite {

  public static Test suite() {
    TestSuite suite = new TestSuite();

    suite.addTestSuite(BoundingTest.class);
    suite.addTestSuite(BoundingBoxTreeTest.class);
    suite.addTestSuite(MatrixPointVectorTest.class);

    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
