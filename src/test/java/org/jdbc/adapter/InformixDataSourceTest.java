package org.jdbc.adapter;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.jdbc.adapter.ifx.Ifx42DataSource;
import org.junit.Test;

import com.informix.jdbcx.IfxDataSource;

/**
 * @author David Matějček
 */
public class InformixDataSourceTest {

  @Test
  public void compareDriverApi() {
    Method[] originalMethods = IfxDataSource.class.getMethods();
    Method[] myMethods = Ifx42DataSource.class.getMethods();
    boolean[] resultOrig = new boolean[originalMethods.length];
    boolean[] resultMy = new boolean[myMethods.length];

    for (int i = 0; i < myMethods.length; i++) {
      final Method m1 = myMethods[i];
      for (Method m2 : originalMethods) {
        if (isSame(m1, m2)) {
          resultMy[i] = true;
          break;
        }
      }
    }

    for (int i = 0; i < originalMethods.length; i++) {
      final Method m2 = originalMethods[i];
      for (Method m1 : myMethods) {
        if (isSame(m1, m2)) {
          resultOrig[i] = true;
          break;
        }
      }
    }


    for (int i = 0; i < resultMy.length; i++) {
      if (!resultMy[i]) {
        System.out.println(String.format("Method is not in original API: %s", myMethods[i]));
      }
    }

    StringBuilder msg = new StringBuilder();
    for (int i = 0; i < resultOrig.length; i++) {
      if (!resultOrig[i]) {
        msg.append(originalMethods[i]).append('\n');
      }
    }
    if (msg.length() > 0) {
      System.err.println("Methods to implement: \n" + msg);
    }
    assertTrue("Some methods are not same as in original driver. See logs.", msg.length() == 0);
  }


  private boolean isSame(final Method m1, final Method m2) {
    if (!m1.getName().equals(m2.getName())) {
      return false;
    }
   if (!m1.getReturnType().equals(m2.getReturnType())) {
      return false;
    }
    final Parameter[] p1 = m1.getParameters();
    final Parameter[] p2 = m2.getParameters();
    if (p1.length != p2.length) {
      return false;
    }
    int i = 0;
    while (i < p1.length) {
      if (!p1[i].getType().equals(p2[i].getType())) {
        return false;
      }
      i++;
    }
    return true;
  }
}
