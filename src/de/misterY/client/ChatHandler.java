package de.misterY.client;

import java.util.ArrayList;

import de.misterY.Player;

public class ChatHandler {
	private ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();

	public void addMessage(Player player, String message) {
		messages.add(new ChatMessage(player, message));
	}

	public String getChatString() {
		String result = "<html>";
		for (ChatMessage chatMessage : messages) {
			result += "<strong>";
			result += chatMessage.getPlayer().getName();
			if (chatMessage.getPlayer().isMrY()) result += " <em>[MisterY]</em>";
			result += ":</strong> ";
			result += chatMessage.getMessage();
			result += "<br>";
		}
		result += "</html>";
		return result;
	}

	private class ChatMessage {
		private Player player;
		private String message;

		public ChatMessage(Player player, String message) {
			this.player = player;
			this.message = message;
		}

		public Player getPlayer() {
			return player;
		}

		public String getMessage() {
			return message;
		}
	}
}
