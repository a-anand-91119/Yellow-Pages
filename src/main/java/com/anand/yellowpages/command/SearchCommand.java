package com.anand.yellowpages.command;

public class SearchCommand {

	private String searchText;

	public SearchCommand() {
		super();
	}

	public SearchCommand(String searchText) {
		super();
		this.searchText = searchText;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "SearchCommand [searchText=" + searchText + "]";
	}

}
