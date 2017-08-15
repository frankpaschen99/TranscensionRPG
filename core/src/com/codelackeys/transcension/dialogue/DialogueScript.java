package com.codelackeys.transcension.dialogue;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

/* The DialogueScript class represents an entire conversation with an NPC.
 * All NPC classes will contain a DialogueScript object.
 * This class is responsible for reading a JSON file, then separating it into
 * DialogueLine and DialogueResponse objects.
 */

public class DialogueScript {

	private List<DialogueLine> script = new ArrayList<DialogueLine>();
	private int CURRENT_POSITION = 0;	// first line of dialogue
	
	// this will be called by NPCs
	public DialogueScript(String dialogueFile) {
		// im writing this and never looking at it again - 8/15/17
		JsonReader json = new JsonReader();
		JsonValue base = json.parse(Gdx.files.internal(dialogueFile));
		
		// for every object in "speech" array...
		for (JsonValue entries : base.get("speech")) {
			// create a  new DialogueLine and populate it with the
			// NPC text, and possible player responses
			DialogueLine dL = new DialogueLine();
			dL.dialogueText = entries.getString("text");
			for (JsonValue responses : entries.get("responses")) {
				dL.responses.add(new DialogueResponse(Integer.parseInt(responses.getString("jumpto"))
						, responses.getString("text")));
			}
			script.add(dL);	// add it to the script
		}
	}
	// called by user interface
	public void advanceDialogue(int jumpTo) {
		CURRENT_POSITION = jumpTo;
	}
	// called by user interface
	public String fetchCurrentNPCText() {
		 return script.get(CURRENT_POSITION).dialogueText;
	}
	// called by user interface
	public List<DialogueResponse> fetchPossiblePlayerResponses() {
		return script.get(CURRENT_POSITION).responses;
	}
	
}
