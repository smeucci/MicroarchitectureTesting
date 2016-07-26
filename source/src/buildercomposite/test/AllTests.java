package buildercomposite.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({VariableTest.class, AndTest.class, OrTest.class, ParenthesisTest.class, ConcreteExprBuilderTest.class, DirectorTest.class})
public class AllTests {

}
