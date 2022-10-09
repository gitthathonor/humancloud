<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>

<div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">user register form</h4>
                  <p class="card-description">
                    Basic form layout
                  </p>
                <div class="btn-group m-4" role="group" aria-label="Basic example">
                          <button type="button" class="btn btn-primary">일반</button>
                          <button type="button" class="btn btn-primary">기업</button>
                </div>
                  
                  <form class="forms-sample">
                      <label for="exampleInputUsername1">Username</label>

                    <div class="form-group row">
                        
                      <div class="col-9"><input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username"></div>
                    <div class="col-3"><button class="btn btn-light">중복확인</button></div>
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputUsername1">Name</label>
                      <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Email address</label>
                      <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Phone number</label>
                      <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">Password</label>
                      <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputConfirmPassword1">Confirm Password</label>
                      <input type="password" class="form-control" id="exampleInputConfirmPassword1" placeholder="Password">
                    </div>
                    
                    <div class="row m-3">
                  <div class="col form-check">
                            <label class="form-check-label">
                              <input type="checkbox" class="form-check-input">
                              분야1
                            </label>
                          </div>
                          <div class="col form-check">
                            <label class="form-check-label">
                              <input type="checkbox" class="form-check-input">
                              분야2
                            </label>
                          </div>
                          <div class="col form-check">
                            <label class="form-check-label">
                              <input type="checkbox" class="form-check-input">
                              분야3
                            </label>
                          </div>
                  </div>
                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                    <button class="btn btn-light">Cancel</button>
                  </form>
                </div>
              </div>
            </div>

<%@ include file="../../layout/footer.jsp" %>
