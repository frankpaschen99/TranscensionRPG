package com.codelackeys.transcension.dialogue;

import java.util.ArrayList;
import java.util.List;

/* A dialogue line represents one part of a conversation with an NPC.
   
*/

public class DialogueLine {
	public String dialogueText;
	public List<DialogueResponse> responses = new ArrayList<DialogueResponse>();	
}
