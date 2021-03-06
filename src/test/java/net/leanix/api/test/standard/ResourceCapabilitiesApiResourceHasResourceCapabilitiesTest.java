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

package net.leanix.api.test.standard;

import static org.junit.Assert.*;

import java.util.List;

import net.leanix.api.common.*;
import net.leanix.api.models.ResourceCapability;
import net.leanix.api.models.Resource;
import net.leanix.api.models.ResourceHasResourceCapability;
import net.leanix.api.*;
import net.leanix.api.test.*;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceCapabilitiesApiResourceHasResourceCapabilitiesTest
{
	@ClassRule public static WorkspaceSetupRule setup = new WorkspaceSetupRule();
	@Rule public ExpectedException thrown = ExpectedException.none();

	final Logger logger = LoggerFactory.getLogger(ResourceCapabilitiesApiResourceHasResourceCapabilitiesTest.class);

	protected ResourceCapabilitiesApi getApi() throws Exception
	{
		ResourceCapabilitiesApi api = new ResourceCapabilitiesApi(setup.getApiClient());
		return api;
	}

	protected ResourcesApi getApiRelated() throws Exception
	{
		ResourcesApi api = new ResourcesApi(setup.getApiClient());
		return api;
	}	

	protected ResourceCapability newModel()
	{
		return new ResourceCapability();
	}

	protected Resource newModelRelated()
	{
		return new Resource();
	}

	protected void setAttributes(ResourceHasResourceCapability model)
	{
		// Attributes
		model.setIsLeading(true);
	}

	protected void changeAttributes(ResourceHasResourceCapability model)
	{
		// Attributes
	}

	protected void assertEqual(ResourceHasResourceCapability a, ResourceHasResourceCapability b)
	{
		assertEquals(a.getID(), b.getID());
		assertEquals(a.getResourceCapabilityID(), b.getResourceCapabilityID());
		assertEquals(a.getResourceID(), b.getResourceID());

		// Further attributes		
		assertEquals(a.getIsLeading(), b.getIsLeading());
	}

	protected ResourceCapability createNewModel(String namePart) throws ApiException, Exception
	{
		ResourceCapability model = this.newModel();
		model.setName("ResourceCapability ResourceHasResourceCapability" + namePart);


		ResourceCapability newModel = this.getApi().createResourceCapability(model);
		return newModel;
	}

	protected Resource createNewModelRelated(String namePart) throws ApiException, Exception
	{
		Resource model = this.newModelRelated();
		model.setName("Resource ResourceHasResourceCapability" + namePart);


		Resource newModel = this.getApiRelated().createResource(model);
		return newModel;
	}	

	protected ResourceHasResourceCapability newRelationModel(ResourceCapability model, Resource refModel)
	{
		ResourceHasResourceCapability relationModel = new ResourceHasResourceCapability();
		relationModel.setResourceCapabilityID(model.getID());
		relationModel.setResourceID(refModel.getID());

		this.setAttributes(relationModel);

		return relationModel;
	}

	protected ResourceHasResourceCapability createNewRelationModel(String namePart) throws ApiException, Exception
	{
		ResourceCapability model = this.createNewModel(namePart + "A");
		Resource modelRelated = this.createNewModelRelated(namePart + "B");

		ResourceHasResourceCapability relationModel = this.newRelationModel(model, modelRelated);

		ResourceHasResourceCapability newRelationModel = this.getApi().createResourceHasResourceCapability(model.getID(), relationModel);

		return newRelationModel;
	}

	@Test
	public void testCreateAndGet() throws Exception
	{	
		ResourceHasResourceCapability newRelationModel = this.createNewRelationModel("CreateAndGet");

		assertNotNull(newRelationModel);
		assertNotNull(newRelationModel.getID());

		ResourceHasResourceCapability newGetModel = this.getApi().getResourceHasResourceCapability(newRelationModel.getResourceCapabilityID(), newRelationModel.getID());
		assertNotNull(newGetModel);
		assertNotNull(newGetModel.getID());

		assertEqual(newRelationModel, newGetModel);
	}

	@Test
	public void testUpdate() throws Exception
	{	
		ResourceHasResourceCapability newRelationModel = this.createNewRelationModel("Update");

		this.changeAttributes(newRelationModel);

		ResourceHasResourceCapability updatedModel = this.getApi().updateResourceHasResourceCapability(newRelationModel.getResourceCapabilityID(), newRelationModel.getID(), newRelationModel);

		assertNotNull(updatedModel);
		assertEqual(newRelationModel, updatedModel);
	}

	@Test
	public void testDelete() throws Exception
	{	
		ResourceHasResourceCapability newRelationModel = this.createNewRelationModel("Delete");

		assertNotNull(newRelationModel);

		this.getApi().deleteResourceHasResourceCapability(newRelationModel.getResourceCapabilityID(), newRelationModel.getID());

		List<ResourceHasResourceCapability> models = this.getApi().getResourceHasResourceCapabilities(newRelationModel.getResourceCapabilityID());
		boolean found = false;
		for (ResourceHasResourceCapability s : models)
		{
			if (newRelationModel.getID().equals(s.getID()))
				found = true;	
		}

		// We should no longer find the deleted item
		assertFalse(found);
	}
}