package com.codelackeys.transcension.npcs;

public class NPCBase {
	private DialogueScript script;
	
	public NPCBase(String dialogueFile) {
		script = new DialogueScript(dialogueFile);
	}
}
