INSERT  INTO
	work_flow
      ( 
      id                            
      ,flow_name                      
      ,flow_content                   
      ,flow_chart                     
      ,guide_id                       
      ) 
values
      (
      :workFlow.id                            
      ,:workFlow.flowName                      
      ,:workFlow.flowContent                   
      ,:workFlow.flowChart                     
      ,:workFlow.guideId                       
      )