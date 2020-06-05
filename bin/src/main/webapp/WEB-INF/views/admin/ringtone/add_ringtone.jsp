
<%@ page pageEncoding="ISO-8859-1"  contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@taglib prefix="defaultTemplate" tagdir="/WEB-INF/tags"%>
. 
<defaultTemplate:defaultDecorator>
<jsp:attribute name="title">Status Raja</jsp:attribute>
<jsp:body>

<div id="page_content_inner">
  <h3 class="heading_b uk-margin-bottom">ADD RINGTONE</h3>

  <div class="md-card">
      <div class="md-card-content large-padding">
          <form id="form_validation" action="${contextPath}/admin/add/ringtone"  method="post" enctype="multipart/form-data" class="uk-form-stacked">
              <div class="uk-grid" data-uk-grid-margin>
                  <div class="uk-width-medium-1-2">
                      <div class="parsley-row">
                          <label for="fullname">Song Full Name <span class="req">*</span></label>
                          <input type="text" name="filefullname" required class="md-input" />
                      </div>
                  </div>
                  <div class="uk-width-medium-1-2">
                      <div class="parsley-row">
                          <label for="email">Song Short Name <span class="req">*</span></label>
                          <input type="text" name="fileshortname" data-parsley-trigger="change" required  class="md-input" />
                      </div>
                  </div>
              </div>
              <div class="uk-grid">
                   <div class="uk-width-1-1">
                       <div class="parsley-row">
                           <label for="message">Description (20 chars min, 100 max)</label>
                           <textarea class="md-input" name="description" cols="8" rows="6" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-validation-threshold="10" data-parsley-minlength-message = "Come on! You need to enter at least a 20 caracters long comment.."></textarea>
                       </div>
                   </div>
               </div>
                <div class="md-card">
                <div class="md-card-content">
                <div class="uk-grid" data-uk-grid-margin>
                   <div class="uk-width-medium-1-3">
                    <h3 class="heading_a">Select Language</h3>
                    <div class="uk-grid" data-uk-grid-margin="">
                        <div class="uk-width-medium-1-3 uk-row-first">
                             <select name="language" style="width: 159px;">
                            	<option	value="hindi">Hindi</option>
                            	<option value="telugu">Telugu</option>
                            	<option	value="tamil">Tamil</option>
                            	<option	value="malayalam">Malayalam</option>
                            </select>
                        </div>
                    </div>
                    </div>
                     <div class="uk-width-medium-1-3">
                    <h3 class="heading_a">Select Category</h3>
                    <div class="uk-grid" data-uk-grid-margin="">
                        <div class="uk-width-medium-1-3 uk-row-first">
                           <select name="category"  style="width: 159px;">
                            	<option	value="melody">Melody</option>
                            	<option value="romantic">Romantic</option>
                            	<option	value="children">Children</option>
                            	<option	value="emotional">Emotional</option>
                            	<option	value="love">Love</option>
                            	<option	value="devotional">Devotional</option>
                            	<option	value="dance">Dance</option>
                            	<option	value="friendship">Friendship</option>
                            </select>
                        </div>
                    </div>
                   </div> 
                </div>
            </div>
              </div>
               <div class="md-card">
                <div class="md-card-content">
                   <!--  <h3 class="heading_a">
                        Upload Component
                        <span class="sub-heading">Allow users to upload files through a file input form element or a placeholder area.</span>
                    </h3> -->
                    <div class="uk-grid">
                        <div class="uk-width-1-1">
                            <div id="file_upload-drop" class="uk-file-upload">
                                <p class="uk-text">Drop file to upload</p>
                                <p class="uk-text-muted uk-text-small uk-margin-small-bottom">or</p>
                                <a class="uk-form-file md-btn">choose file<input id="file_upload-select" name="file" type="file"></a>
                            </div>
                            <div id="file_upload-progressbar" class="uk-progress uk-hidden">
                                <div class="uk-progress-bar" style="width:0">0%</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
              <div class="uk-grid">
                  <div class="uk-width-1-1">
                      <button type="submit" class="md-btn md-btn-primary">Submit</button>
                  </div>
              </div>
          </form>
        </div>
    </div>
</div>
        
 </jsp:body>
 </defaultTemplate:defaultDecorator>       