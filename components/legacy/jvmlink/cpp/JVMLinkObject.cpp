//
// JVMLinkObject.cpp
//

/*
JVMLink client/server architecture for communicating between Java and
non-Java programs using sockets.
Copyright (c) 2008 Hidayath Ansari and Curtis Rueden. All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
  * Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
  * Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
  * Neither the name of the UW-Madison LOCI nor the names of its
    contributors may be used to endorse or promote products derived from
    this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE UW-MADISON LOCI ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

#include "stdafx.h"
#include "JVMLinkObject.h"

JVMLinkObject::JVMLinkObject(CString name) {
	this->name = name;
}

// Constructor for single primitives
JVMLinkObject::JVMLinkObject(CString name, Type type, void* data) {
	this->name = name;
	this->size = getSize(type);
	this->length = 1;
	this->type = type;
	this->data = data;
}

// Constructor for arrays
JVMLinkObject::JVMLinkObject(CString name, Type type, int length, void* data) {
	this->name = name;
	this->size = getSize(type);
	this->length = length;
	this->type = ARRAY_TYPE;
	this->insideType = type;
	this->data = data;
}

// Destructor
JVMLinkObject::~JVMLinkObject(void)
{
}

int JVMLinkObject::getDataAsInt() {
	int retval = *(int*) data;
	return retval;
}

int* JVMLinkObject::getDataAsIntArray() {
	int* retval = (int*) data;
	return retval;
}

CString* JVMLinkObject::getDataAsString() {
	CString* retval = (CString*) data;
	return retval;
}

CString* JVMLinkObject::getDataAsStringArray() {
	CString* retval = (CString*) data;
	return retval;
}

Byte JVMLinkObject::getDataAsByte() {
	Byte retval;
	retval.data = *(char*) data;
	return retval;
}

Byte* JVMLinkObject::getDataAsByteArray() {
	Byte* retval = (Byte*) data;
	return retval;
}

char JVMLinkObject::getDataAsChar() {
	char retval = *(char*) data;
	return retval;
}

char* JVMLinkObject::getDataAsCharArray() {
	char* retval = (char*) data;
	return retval;
}

float JVMLinkObject::getDataAsFloat() {
	float retval = *(float*) data;
	return retval;
}

float* JVMLinkObject::getDataAsFloatArray() {
	float* retval = (float*) data;
	return retval;
}

bool JVMLinkObject::getDataAsBool() {
	bool retval = *(bool*) data;
	return retval;
}

bool* JVMLinkObject::getDataAsBoolArray() {
	bool* retval = (bool*) data;
	return retval;
}

double JVMLinkObject::getDataAsDouble() {
	double retval = *(double*) data;
	return retval;
}

double* JVMLinkObject::getDataAsDoubleArray() {
	double* retval = (double*) data;
	return retval;
}

long long JVMLinkObject::getDataAsLong() {
	long long retval = *(long long*) data;
	return retval;
}

long long* JVMLinkObject::getDataAsLongArray() {
	long long* retval = (long long*) data;
	return retval;
}

short JVMLinkObject::getDataAsShort() {
	short retval = *(short*) data;
	return retval;
}

short* JVMLinkObject::getDataAsShortArray() {
	short* retval = (short*) data;
	return retval;
}

bool JVMLinkObject::isDataNull() {
	return type == NULL_TYPE;
}

int JVMLinkObject::getSize(Type type) {
	switch (type) {
		case BYTE_TYPE:
		case CHAR_TYPE:
		case BOOL_TYPE:
			return 1;
		case SHORT_TYPE:
			return 2;
		case INT_TYPE:
		case FLOAT_TYPE:
			return 4;
		case DOUBLE_TYPE:
		case LONG_TYPE:
			return 8;
		case NULL_TYPE:
		case STRING_TYPE: // string size is variable
		default:
			return 0;
	}
}