/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.rest.service.api.management;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineInfo;
import org.activiti.rest.common.api.ActivitiUtil;
import org.activiti.rest.common.api.SecuredResource;
import org.restlet.resource.Get;

/**
 * @author Tijs Rademakers
 */
public class ProcessEngineResource extends SecuredResource {

  @Get
  public ProcessEngineInfoResponse getEngineInfo() {
    if(authenticate() == false) return null;
    
    ProcessEngineInfoResponse response = new ProcessEngineInfoResponse();
    
    ProcessEngineInfo engineInfo = ActivitiUtil.getProcessEngineInfo();
    if(engineInfo != null) {
      response.setName(engineInfo.getName());
      response.setResourceUrl(engineInfo.getResourceUrl());
      response.setException(engineInfo.getException());
    } else {
      // Revert to using process-engine directly
      ProcessEngine engine = ActivitiUtil.getProcessEngine();
      response.setName(engine.getName());
    }
   
    response.setVersion(ProcessEngine.VERSION);
    return response;
  }
}