
/**
 * FiapBOCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package br.com.fiap.ws.bo;

    /**
     *  FiapBOCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class FiapBOCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public FiapBOCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public FiapBOCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for calularPsMedia method
            * override this method for handling normal response from calularPsMedia operation
            */
           public void receiveResultcalularPsMedia(
                    br.com.fiap.ws.bo.FiapBOStub.CalularPsMediaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calularPsMedia operation
           */
            public void receiveErrorcalularPsMedia(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for calcularPs method
            * override this method for handling normal response from calcularPs operation
            */
           public void receiveResultcalcularPs(
                    br.com.fiap.ws.bo.FiapBOStub.CalcularPsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calcularPs operation
           */
            public void receiveErrorcalcularPs(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for calcularMedia method
            * override this method for handling normal response from calcularMedia operation
            */
           public void receiveResultcalcularMedia(
                    br.com.fiap.ws.bo.FiapBOStub.CalcularMediaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calcularMedia operation
           */
            public void receiveErrorcalcularMedia(java.lang.Exception e) {
            }
                


    }
    