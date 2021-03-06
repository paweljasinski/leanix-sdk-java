/*
 * The MIT License (MIT)	 
 *
 * Copyright (c) 2013 LeanIX GmbH
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

import java.util.List;

import net.leanix.api.*;
import net.leanix.api.common.*;
import net.leanix.api.models.*;

public class UsersTest
{
	public static void main(String[] args)
	{
		try
		{
			ApiClient apiClient = new ApiClient();
			apiClient.setBasePath("https://app.leanix.net/demo/api/v1");
			apiClient.setApiKey("a42cb9ad37294968615ce6d12849612e");
			
			UsersApi usersApi = new UsersApi(apiClient);
			List<User> users = usersApi.getUsers(true);
			for (User cur : users)
			{
				System.out.println(cur);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Exception: " + ex.getMessage());
		}
	}

}
