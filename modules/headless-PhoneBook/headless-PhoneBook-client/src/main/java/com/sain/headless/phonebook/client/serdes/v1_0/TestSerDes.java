package com.sain.headless.phonebook.client.serdes.v1_0;

import com.sain.headless.phonebook.client.dto.v1_0.Test;
import com.sain.headless.phonebook.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Amir
 * @generated
 */
@Generated("")
public class TestSerDes {

	public static Test toDTO(String json) {
		TestJSONParser testJSONParser = new TestJSONParser();

		return testJSONParser.parseToDTO(json);
	}

	public static Test[] toDTOs(String json) {
		TestJSONParser testJSONParser = new TestJSONParser();

		return testJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Test test) {
		if (test == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (test.getText() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"text\": ");

			sb.append("\"");

			sb.append(_escape(test.getText()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TestJSONParser testJSONParser = new TestJSONParser();

		return testJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Test test) {
		if (test == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (test.getText() == null) {
			map.put("text", null);
		}
		else {
			map.put("text", String.valueOf(test.getText()));
		}

		return map;
	}

	public static class TestJSONParser extends BaseJSONParser<Test> {

		@Override
		protected Test createDTO() {
			return new Test();
		}

		@Override
		protected Test[] createDTOArray(int size) {
			return new Test[size];
		}

		@Override
		protected void setField(
			Test test, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "text")) {
				if (jsonParserFieldValue != null) {
					test.setText((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}