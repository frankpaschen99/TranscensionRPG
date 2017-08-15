package com.codelackeys.transcension.npcs;

import com.codelackeys.transcension.dialogue.DialogueScript;

public class NPCBase {
	private DialogueScript script;
	
	public NPCBase(String dialogueFile) {
		script = new DialogueScript(dialogueFile);
	}
}
