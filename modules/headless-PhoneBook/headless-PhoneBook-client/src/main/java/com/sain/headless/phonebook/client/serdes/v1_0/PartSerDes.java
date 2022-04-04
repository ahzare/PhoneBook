package com.sain.headless.phonebook.client.serdes.v1_0;

import com.sain.headless.phonebook.client.dto.v1_0.Part;
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
public class PartSerDes {

	public static Part toDTO(String json) {
		PartJSONParser partJSONParser = new PartJSONParser();

		return partJSONParser.parseToDTO(json);
	}

	public static Part[] toDTOs(String json) {
		PartJSONParser partJSONParser = new PartJSONParser();

		return partJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Part part) {
		if (part == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (part.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append(String.valueOf(part.getAddress()));
		}

		if (part.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(part.getId()));

			sb.append("\"");
		}

		if (part.getInternalPhone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"internalPhone\": ");

			sb.append("\"");

			sb.append(_escape(part.getInternalPhone()));

			sb.append("\"");
		}

		if (part.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(part.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PartJSONParser partJSONParser = new PartJSONParser();

		return partJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Part part) {
		if (part == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (part.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(part.getAddress()));
		}

		if (part.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(part.getId()));
		}

		if (part.getInternalPhone() == null) {
			map.put("internalPhone", null);
		}
		else {
			map.put("internalPhone", String.valueOf(part.getInternalPhone()));
		}

		if (part.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(part.getName()));
		}

		return map;
	}

	public static class PartJSONParser extends BaseJSONParser<Part> {

		@Override
		protected Part createDTO() {
			return new Part();
		}

		@Override
		protected Part[] createDTOArray(int size) {
			return new Part[size];
		}

		@Override
		protected void setField(
			Part part, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					part.setAddress(
						AddressSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					part.setId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "internalPhone")) {
				if (jsonParserFieldValue != null) {
					part.setInternalPhone((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					part.setName((String)jsonParserFieldValue);
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