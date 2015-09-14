package com.gemstone.gemfire.test.dunit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.gemstone.gemfire.distributed.DistributedMemberDUnitTest;
import com.gemstone.gemfire.distributed.HostedLocatorsDUnitTest;
import com.gemstone.gemfire.internal.offheap.OutOfOffHeapMemoryDUnitTest;
import com.gemstone.gemfire.test.dunit.rules.tests.DistributedRestoreSystemPropertiesDUnitTest;
import com.gemstone.gemfire.test.examples.CatchExceptionExampleDUnitTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  BasicDUnitTest.class,
  DistributedRestoreSystemPropertiesDUnitTest.class,
  DistributedTestNameDUnitTest.class,
  DistributedTestNameWithRuleDUnitTest.class,
  DUnitTestRuleChainDUnitTest.class,
  SerializableTemporaryFolderDUnitTest.class,
  SerializableTestNameDUnitTest.class,
  SerializableTestWatcherDUnitTest.class,
  VMDUnitTest.class,
  LogPerTestMethodDUnitTest.class,
  
  CatchExceptionExampleDUnitTest.class,
  DistributedMemberDUnitTest.class,
  HostedLocatorsDUnitTest.class,
  OutOfOffHeapMemoryDUnitTest.class,
})
public class MyTestSuite {
}
