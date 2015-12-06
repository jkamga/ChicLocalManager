package com.journaldev.spring.parser;

import java.io.IOException;
import java.text.ParseException;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

class KeyFinder implements ContentHandler{
	  private Object value;
	  private boolean found = false;
	  private boolean end = false;
	  private String key;
	  private String matchKey;
	        
	  public void setMatchKey(String matchKey){
	    this.matchKey = matchKey;
	  }
	        
	  public Object getValue(){
	    return value;
	  }
	        
	  public boolean isEnd(){
	    return end;
	  }
	        
	  public void setFound(boolean found){
	    this.found = found;
	  }
	        
	  public boolean isFound(){
	    return found;
	  }
	        
	  public void startJSON() throws ParseException, IOException {
	    found = false;
	    end = false;
	  }

	  public void endJSON() throws ParseException, IOException {
	    end = true;
	  }

	  public boolean primitive(Object value) throws ParseException, IOException {
	    if(key != null){
	      if(key.equals(matchKey)){
	        found = true;
	        this.value = value;
	        key = null;
	        return false;
	      }
	    }
	    return true;
	  }

	  public boolean startArray() throws ParseException, IOException {
	    return true;
	  }

	        
	  public boolean startObject() throws ParseException, IOException {
	    return true;
	  }

	  public boolean startObjectEntry(String key) throws ParseException, IOException {
	    this.key = key;
	    return true;
	  }
	        
	  public boolean endArray() throws ParseException, IOException {
	    return false;
	  }

	  public boolean endObject() throws ParseException, IOException {
	    return true;
	  }

	  public boolean endObjectEntry() throws ParseException, IOException {
	    return true;
	  }

	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	
	}