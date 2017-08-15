package com.codelackeys.transcension.dialogue;

public class DialogueResponse {
	public int jumpTo = 0;
	public String responseText;
	
	public DialogueResponse(int j, String r) {
		this.jumpTo = j;
		this.responseText = r;
	}
}
