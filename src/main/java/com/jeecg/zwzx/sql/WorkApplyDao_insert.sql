INSERT  INTO
	work_apply
      ( 
      ID                            
      ,MANAGEMENT                     
      ,GUIDE_ID                       
      ,ID_NUMBER                      
      ,APPLY_SUBJECT                  
      ,LEGAL_REPRESENT                
      ,CONTACT                        
      ,MOBILE                         
      ,PHONE                          
      ,ADDRESS                        
      ,RECEIVE_TYPE                   
      ,APPLY_NUM                      
      ,APPLY_STATUS                   
      ,APPLY_DATA                     
      ,DEAL_DATA                      
      ,DEAL_PERSION                   
      ,AUDIT                          
      ,REPLY                          
      ,material       
      ,processInstanceId
      ,res_code       
      ,open_id
      ,form_id
      ) 
values
      (
      :workApply.id                            
      ,:workApply.management                    
      ,:workApply.guideId                       
      ,:workApply.idNumber                      
      ,:workApply.applySubject                  
      ,:workApply.legalRepresent                
      ,:workApply.contact                       
      ,:workApply.mobile                        
      ,:workApply.phone                         
      ,:workApply.address                       
      ,:workApply.receiveType                   
      ,:workApply.applyNum                      
      ,:workApply.applyStatus                   
      ,:workApply.applyData                     
      ,:workApply.dealData                      
      ,:workApply.dealPersion                   
      ,:workApply.audit                         
      ,:workApply.reply                         
      ,:workApply.material     
      ,:workApply.processInstanceId
      ,:workApply.resCode     
      ,:workApply.openId
      ,:workApply.formId
      )