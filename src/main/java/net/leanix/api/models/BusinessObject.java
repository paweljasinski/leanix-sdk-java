/*
* The MIT License (MIT)	 
*
* Copyright (c) 2014 LeanIX GmbH
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy of
* this software and associated documentation files (the "Software"), to deal in
* the Software without restriction, including without limitation the rights to
* use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
* the Software, and to permit persons to whom the Software is furnished to do so,
* subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
* FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
* COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
* IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
* CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package net.leanix.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
import net.leanix.api.models.FactSheetHasDocument;
import net.leanix.api.models.ServiceHasBusinessObject;
public class BusinessObject
{
	/*  */
	private String ID = null;
	/*  */
	private String name = null;
	/*  */
	private String reference = null;
	/*  */
	private String alias = null;
	/*  */
	private String description = null;
	/*  */
	private String dataClassificationID = null;
	/*  */
	private String dataClassificationDescription = null;
	/*  */
	private List<String> tags = new ArrayList<String>();
	/*  */
	private List<ServiceHasBusinessObject> serviceHasBusinessObjects = new ArrayList<ServiceHasBusinessObject>();
	/*  */
	private List<FactSheetHasDocument> factSheetHasDocuments = new ArrayList<FactSheetHasDocument>();
	@JsonProperty("ID")
	public String getID()
	{
		return ID;
	}
	
	@JsonProperty("ID")
	public void setID(String ID)
	{
		this.ID = ID;
	}

	@JsonProperty("name")
	public String getName()
	{
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name)
	{
		this.name = name;
	}

	@JsonProperty("reference")
	public String getReference()
	{
		return reference;
	}
	
	@JsonProperty("reference")
	public void setReference(String reference)
	{
		this.reference = reference;
	}

	@JsonProperty("alias")
	public String getAlias()
	{
		return alias;
	}
	
	@JsonProperty("alias")
	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	@JsonProperty("description")
	public String getDescription()
	{
		return description;
	}
	
	@JsonProperty("description")
	public void setDescription(String description)
	{
		this.description = description;
	}

	@JsonProperty("dataClassificationID")
	public String getDataClassificationID()
	{
		return dataClassificationID;
	}
	
	@JsonProperty("dataClassificationID")
	public void setDataClassificationID(String dataClassificationID)
	{
		this.dataClassificationID = dataClassificationID;
	}

	@JsonProperty("dataClassificationDescription")
	public String getDataClassificationDescription()
	{
		return dataClassificationDescription;
	}
	
	@JsonProperty("dataClassificationDescription")
	public void setDataClassificationDescription(String dataClassificationDescription)
	{
		this.dataClassificationDescription = dataClassificationDescription;
	}

	@JsonProperty("tags")
	public List<String> getTags()
	{
		return tags;
	}
	
	@JsonProperty("tags")
	public void setTags(List<String> tags)
	{
		this.tags = tags;
	}

	@JsonProperty("serviceHasBusinessObjects")
	public List<ServiceHasBusinessObject> getServiceHasBusinessObjects()
	{
		return serviceHasBusinessObjects;
	}
	
	@JsonProperty("serviceHasBusinessObjects")
	public void setServiceHasBusinessObjects(List<ServiceHasBusinessObject> serviceHasBusinessObjects)
	{
		this.serviceHasBusinessObjects = serviceHasBusinessObjects;
	}

	@JsonProperty("factSheetHasDocuments")
	public List<FactSheetHasDocument> getFactSheetHasDocuments()
	{
		return factSheetHasDocuments;
	}
	
	@JsonProperty("factSheetHasDocuments")
	public void setFactSheetHasDocuments(List<FactSheetHasDocument> factSheetHasDocuments)
	{
		this.factSheetHasDocuments = factSheetHasDocuments;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class BusinessObject {\n");
		sb.append("  ID: ").append(ID).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  reference: ").append(reference).append("\n");
		sb.append("  alias: ").append(alias).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("  dataClassificationID: ").append(dataClassificationID).append("\n");
		sb.append("  dataClassificationDescription: ").append(dataClassificationDescription).append("\n");
		sb.append("  tags: ").append(tags).append("\n");
		sb.append("  serviceHasBusinessObjects: ").append(serviceHasBusinessObjects).append("\n");
		sb.append("  factSheetHasDocuments: ").append(factSheetHasDocuments).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}

