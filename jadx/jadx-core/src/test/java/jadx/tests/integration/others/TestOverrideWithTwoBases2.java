package jadx.tests.integration.others;

import org.junit.jupiter.api.Test;

import jadx.tests.api.IntegrationTest;

import static jadx.tests.api.utils.assertj.JadxAssertions.assertThat;

public class TestOverrideWithTwoBases2 extends IntegrationTest {

	public static class TestCls {
		public interface I {
			int a();
		}

		public abstract static class BaseCls implements I {
		}

		public static class Cls extends BaseCls implements I {
			@Override
			public int a() {
				return 2;
			}
		}
	}

	@Test
	public void test() {
		assertThat(getClassNode(TestCls.class))
				.code()
				.containsOne("@Override");
	}
}
