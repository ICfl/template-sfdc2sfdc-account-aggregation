package org.mule.kicks.transformers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;

@RunWith(MockitoJUnitRunner.class)
public class SortUsersListTest {

	@Mock
	private MuleContext muleContext;

	@Test
	@SuppressWarnings("unchecked")
	public void testSort() throws TransformerException {

		MuleMessage message = new DefaultMuleMessage(createOriginalList(), muleContext);

		SortAccountsList transformer = new SortAccountsList();
		List<Map<String, String>> sortedList = (List<Map<String, String>>) transformer.transform(message, "UTF-8");

		System.out.println(sortedList);
		Assert.assertEquals("The merged list obtained is not as expected", createExpectedList(), sortedList);

	}

	private List<Map<String, String>> createExpectedList() {
		Map<String, String> user0 = new HashMap<String, String>();
		user0.put("IDInA", "0");
		user0.put("IDInB", "");
		user0.put("Name", "SomeName_0");

		Map<String, String> user1 = new HashMap<String, String>();
		user1.put("IDInA", "1");
		user1.put("IDInB", "1");
		user1.put("Name", "SomeName_1");

		Map<String, String> user2 = new HashMap<String, String>();
		user2.put("IDInA", "");
		user2.put("IDInB", "2");
		user2.put("Name", "SomeName_2");

		List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
		userList.add(user0);
		userList.add(user2);
		userList.add(user1);

		return userList;

	}

	private List<Map<String, String>> createOriginalList() {
		Map<String, String> user0 = new HashMap<String, String>();
		user0.put("IDInA", "0");
		user0.put("IDInB", "");
		user0.put("Name", "SomeName_0");

		Map<String, String> user1 = new HashMap<String, String>();
		user1.put("IDInA", "1");
		user1.put("IDInB", "1");
		user1.put("Name", "SomeName_1");

		Map<String, String> user2 = new HashMap<String, String>();
		user2.put("IDInA", "");
		user2.put("IDInB", "2");
		user2.put("Name", "SomeName_2");

		List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
		userList.add(user0);
		userList.add(user1);
		userList.add(user2);

		return userList;

	}

}