package com.gemstone.gemfire.test.examples;

import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static com.googlecode.catchexception.apis.CatchExceptionHamcrestMatchers.*;
import static org.assertj.core.api.BDDAssertions.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.gemstone.gemfire.test.junit.categories.UnitTest;

/**
 * Simple unit tests exercising Catch-Exception with AssertJ, Hamcrest and JUnit.
 */
@Category(UnitTest.class)
public class CatchExceptionExampleJUnitTest {

  @Test
  public void catchExceptionShouldCatchException() {
    List<?> myList = new ArrayList<Object>();

    // when: we try to get the first element of the list
    // then: catch the exception if any is thrown
    catchException(myList).get(1);
    
    // then: we expect an IndexOutOfBoundsException
    assertThat(caughtException(), is(instanceOf(IndexOutOfBoundsException.class)));
  }
  
  @Test
  public void verifyExceptionShouldCatchException() {
    List<?> myList = new ArrayList<Object>();

    // when: we try to get the first element of the list
    // then: catch the exception if any is thrown
    // then: we expect an IndexOutOfBoundsException
    verifyException(myList, IndexOutOfBoundsException.class).get(1);
  }
  
  @Test
  public void whenShouldCatchExceptionAndUseAssertJAssertion() {
    // given: an empty list
    List<?> myList = new ArrayList<Object>();

    // when: we try to get the first element of the list
    when(myList).get(1);

    // then: we expect an IndexOutOfBoundsException
    then((Exception)caughtException())
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("Index: 1, Size: 0")
            .hasNoCause();
  }
  
  @Test
  public void catchExceptionShouldCatchExceptionAndUseHamcrestAssertion() {
    // given: an empty list
    List<?> myList = new ArrayList<Object>();

    // when: we try to get the first element of the list
    catchException(myList).get(1);

    // then: we expect an IndexOutOfBoundsException with message "Index: 1, Size: 0"
    assertThat(caughtException(),
      allOf(
        instanceOf(IndexOutOfBoundsException.class),
        hasMessage("Index: 1, Size: 0"),
        hasNoCause()
      )
    );
  }
  
  @Test
  public void shouldCatchFromThrowException() throws Exception {
    String message = "error message";
    
    catchException(this).throwException(message);
    
    assertThat(caughtException(), is(instanceOf(Exception.class)));
  }
  
  @Test
  public void shouldVerifyFromThrowException() throws Exception {
    String message = "error message";

    verifyException(this).throwException(message);
  }
  
  // fails if private
  protected void throwException(final String message) throws Exception {
    throw new Exception(message);
  }
}
