<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid section">
<input type="hidden" id="type" value="${ type }" />

<c:if test="${ type == 'EDIT' }">
<c:forEach var="ben" items="${ beneficiaries }">
	<c:if test="${ben.id == beneficiary_id }">
		<input type="hidden" id="beneficiary_id" value="${ ben.id }"/>
		 <input type="hidden" name="ACTION" id="ACTION" value="EDIT_BENEFICIARY" />
	
		<div class="form-group">
			<label for="firstName" class="col-sm-5 control-label">First Name:</label>
			<div class="col-sm-7">
				<input type="text" name="firstName" id="firstName" placeholder="First Name" class="form-control  input-sm" value="${ ben.firstname }" />
			</div>
		</div>
		<div class="form-group">
			<label for="surname" class="col-sm-5 control-label">Surname:</label>
			<div class="col-sm-7">
				<input type="text" name="surname" id="ben_surname" placeholder="Surname" class="form-control  input-sm" value="${ ben.surname }" />
			</div>
		</div>
		<div class="form-group">
			<label for="othernames" class="col-sm-5 control-label">Other Names:</label>
			<div class="col-sm-7">
				<input type="text" name="othernames" id="othernames" placeholder="Other Names" class="form-control  input-sm" value="${ ben.othernames }" />
			</div>
		</div>
		<div class="form-group">
			<label for="lumpsum" class="col-sm-5 control-label">Lumpsum Entitlement:</label>
			<div class="col-sm-7">
				<input type="text" name="lumpsum" id="lumpsum" placeholder="Lumpsum Entitlement" class="form-control  input-sm" value="${ ben.lumpsumEntitlement }" />
			</div>
		</div>
		<div class="form-group">
			<label for="gender" class="col-sm-5 control-label" >Gender:</label>
			<div class="col-sm-7">

				<select name="gender" id="gender" class="form-control input-sm"  >
					<c:set var="gender" value="${ ben.gender}"/>
					<c:set var="gender2" value="${fn:toUpperCase(gender)}" />
					<option hidden >${gender2}</option>
					<option ${ ben.gender == 'MALE' ? 'selected="selected"' : '' }>MALE</option>
					<option ${ ben.gender == 'FEMALE' ? 'selected="selected"' : '' }>FEMALE</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="relationship" class="col-sm-5 control-label">Relationship:</label>
			<div class="col-sm-7">
				<select name="relationship" id="relationship" class="form-control input-sm" value="${ ben.relationship }">
					<c:set var="relationship" value="${ ben.relationship}"/>
					<c:set var="relationship2" value="${fn:toUpperCase(relationship)}" />
					<option hidden >${relationship2}</option>
					<option ${ ben.relationship == 'WIFE' ? 'selected="selected"' : '' }>WIFE</option>
					<option ${ ben.relationship == 'HUSBAND' ? 'selected="selected"' : '' }>HUSBAND</option>
					<option ${ ben.relationship == 'DAUGHTER' ? 'selected="selected"' : '' }>DAUGHTER</option>
					<option ${ ben.relationship == 'SON' ? 'selected="selected"' : '' }>SON</option>
					<option ${ ben.relationship == 'MOTHER' ? 'selected="selected"' : '' }>MOTHER</option>
					<option ${ ben.relationship == 'FATHER' ? 'selected="selected"' : '' }>FATHER</option>
					<option ${ ben.relationship == 'BROTHER' ? 'selected="selected"' : '' }>BROTHER</option>
					<option ${ ben.relationship == 'SISTER' ? 'selected="selected"' : '' }>SISTER</option>
					<option ${ ben.relationship == 'OTHER' ? 'selected="selected"' : '' }>OTHER</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="relationshipCategory" class="col-sm-5 control-label">Relationship Category:</label>
			<div class="col-sm-7">
				<select name="relationshipCategory" id="relationshipCategory" class="form-control input-sm"  value="${ ben.relShipCategory }">
					<c:set var="relationshipCategory" value="${ ben.relShipCategory}"/>
					<c:set var="relationshipCategory2" value="${fn:toUpperCase(relationshipCategory)}" />
					<option hidden >${relationshipCategory2}</option>
					<option ${ relationshipCategory2 == 'NEXT OF KIN' ? 'selected="selected"' : '' }>NEXT_OF_KIN</option>
					<option ${ ben.relShipCategory == 'BENEFICIARY' ? 'selected="selected"' : '' }>BENEFICIARY</option>
					<option ${ ben.relShipCategory == 'BOTH' ? 'selected="selected"' : '' }>BOTH</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="mStatus" class="col-sm-5 control-label">Marital Status:</label>
			<div class="col-sm-7">
				<select name="mStatus" id="mStatus" class="form-control input-sm" value="${ ben.mstatus }">
					<c:set var="mStatus" value="${ ben.mstatus}"/>
					<c:set var="mStatus2" value="${fn:toUpperCase(mStatus)}" />
					<option hidden >${mStatus2}</option>
					<option ${ ben.mstatus == 'SINGLE' ? 'selected="selected"' : '' }>SINGLE</option>
					<option ${ ben.mstatus == 'MARRIED' ? 'selected="selected"' : '' }>MARRIED</option>
					<option ${ ben.mstatus == 'SEPARATED' ? 'selected="selected"' : '' }>SEPARATED</option>
					<option ${ ben.mstatus == 'DIVORCED' ? 'selected="selected"' : '' }>DIVORCED</option>
					<option ${ ben.mstatus == 'WIDOWED' ? 'selected="selected"' : '' }>WIDOWED</option>
					<option ${ ben.mstatus == 'NOT_SPECIFIED' ? 'selected="selected"' : '' }>NOT_SPECIFIED</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="status" class="col-sm-5 control-label">Status:</label>
			<div class="col-sm-7">
				<select name="status" id="status" class="form-control input-sm" value="${ ben.status }">
					<c:set var="status" value="${ ben.status}"/>
					<c:set var="status2" value="${fn:toUpperCase(status)}" />
					<option hidden >${status2}</option>
					<option ${ ben.status == 'ELIGIBLE' ? 'selected="selected"' : '' }>ELIGIBLE</option>
					<option ${ ben.status == 'INELIGIBLE' ? 'selected="selected"' : '' }>INELIGIBLE</option>
					<option ${ ben.status == 'MARRIED' ? 'selected="selected"' : '' }>MARRIED</option>
					<option ${ ben.status == 'DIVORCED' ? 'selected="selected"' : '' }>DIVORCED</option>
					<option ${ ben.status == 'DECEASED' ? 'selected="selected"' : '' }>DECEASED</option>
					<option ${ ben.status == 'NOT_SPECIFIED' ? 'selected="selected"' : '' }>NOT_SPECIFIED</option>
				</select>
			</div>
		</div>
		<div class="form-group">
    		<label for="attachment" class="col-sm-5 control-label">Upload File:</label>
    		<div class="col-sm-7">
    			<input type="file" id="attachment" name="attachment" class="filestyle">
    		</div> 
  		</div>
	</c:if>
</c:forEach>
</c:if>
<c:if test="${ type == 'ADD' }"> 
<input type="hidden" id="beneficiary_id" value="0"/>
	<input type="hidden" name="ACTION" id="ACTION" value="EDIT_BENEFICIARY" />
		<div class="form-group">
			<label for="firstName" class="col-sm-5 control-label">First Name:</label>
			<div class="col-sm-7">
				<input type="text" name="firstName" id="firstName" placeholder="First Name" class="form-control  input-sm" />
			</div>
		</div>
		<div class="form-group">
			<label for="ben_surname" class="col-sm-5 control-label">Surname:</label>
			<div class="col-sm-7">
				<input type="text" name="surname" id="ben_surname" placeholder="Surname" class="form-control  input-sm" />
			</div>
		</div>
		<div class="form-group">
			<label for="othernames" class="col-sm-5 control-label">Other Names:</label>
			<div class="col-sm-7">
				<input type="text" name="othernames" id="othernames" placeholder="Other Names" class="form-control input-sm"/>
			</div>
		</div>
		<div class="form-group">
			<label for="lumpsum" class="col-sm-5 control-label">Lumpsum Entitlement:</label>
			<div class="col-sm-7">
				<input type="text" name="lumpsum" id="lumpsum" placeholder="Lumpsum Entitlement" class="form-control  input-sm" />
			</div>
		</div>
		<div class="form-group">
			<label for="gender" class="col-sm-5 control-label">Gender:</label>
			<div class="col-sm-7">
				<select name="gender" id="gender" class="form-control input-sm">
						<option>MALE</option>
						<option>FEMALE</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="relationship" class="col-sm-5 control-label">Relationship:</label>
			<div class="col-sm-7">
				<select name="relationship" id="relationship" class="form-control input-sm">
					<option>WIFE</option>
					<option>HUSBAND</option>
					<option>DAUGHTER</option>
					<option>SON</option>
					<option>MOTHER</option>
					<option>FATHER</option>
					<option>BROTHER</option>
					<option>SISTER</option>
					<option>OTHER</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="relationshipCategory" class="col-sm-5 control-label">Relationship Category:</label>
			<div class="col-sm-7">
				<select name="relationshipCategory" id="relationshipCategory" class="form-control input-sm">
					<option>NEXT_OF_KIN</option>
					<option>BENEFICIARY</option>
					<option>BOTH</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="mStatus" class="col-sm-5 control-label">Marital Status:</label>
			<div class="col-sm-7">
				<select name="mStatus" id="mStatus" class="form-control input-sm">
					<option>SINGLE</option>
					<option>MARRIED</option>
					<option>SEPARATED</option>
					<option>DIVORCED</option>
					<option>WIDOWED</option>
					<option>NOT_SPECIFIED</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="status" class="col-sm-5 control-label">Status:</label>
			<div class="col-sm-7">
				<select name="status" id="status" class="form-control input-sm">
					<option>ELIGIBLE</option>
					<option>INELIGIBLE</option>
					<option>MARRIED</option>
					<option>DIVORCED</option>
					<option>DECEASED</option>
					<option>NOT_SPECIFIED</option>
				</select>
			</div>
		</div>
	<div class="form-group">
    		<label for="attachment" class="col-sm-5 control-label">Upload File:</label>
    		<div class="col-sm-7">
    			<input type="file" id="attachment" name="attachment" class="filestyle">
    		</div> 
  		</div>
</c:if>
</div>
