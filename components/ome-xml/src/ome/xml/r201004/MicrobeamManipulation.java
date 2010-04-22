/*
 * ome.xml.r201004.MicrobeamManipulation
 *
 *-----------------------------------------------------------------------------
 *
 *  Copyright (C) @year@ Open Microscopy Environment
 *      Massachusetts Institute of Technology,
 *      National Institutes of Health,
 *      University of Dundee,
 *      University of Wisconsin-Madison
 *
 *
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *-----------------------------------------------------------------------------
 */

/*-----------------------------------------------------------------------------
 *
 * THIS IS AUTOMATICALLY GENERATED CODE.  DO NOT MODIFY.
 * Created by callan via xsd-fu on 2010-04-22 17:05:10+0100
 *
 *-----------------------------------------------------------------------------
 */

package ome.xml.r201004;

import java.util.ArrayList;
import java.util.List;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ome.xml.r201004.enums.*;

public class MicrobeamManipulation extends AbstractOMEModelObject
{
	// -- Constants --

	public static final String NAMESPACE = "http://www.openmicroscopy.org/Schemas/OME/2010-04";

	// -- Instance variables --

	// Property
	private MicrobeamManipulationType type;

	// Property
	private String id;

	// Reference ROIRef
	private List<ROI> roiList = new ArrayList<ROI>();

	// Property
	private Experimenter experimenter;

	// Property which occurs more than once
	private List<LightSourceSettings> lightSourceSettingsList = new ArrayList<LightSourceSettings>();

	// Back reference Image_BackReference
	private List<Image> image_BackReferenceList = new ArrayList<Image>();

	// -- Constructors --

	/** Default constructor. */
	public MicrobeamManipulation()
	{
		super();
	}

	/** 
	 * Constructs MicrobeamManipulation recursively from an XML DOM tree.
	 * @param element Root of the XML DOM tree to construct a model object
	 * graph from.
	 * @throws EnumerationException If there is an error instantiating an
	 * enumeration during model object creation.
	 */
	public MicrobeamManipulation(Element element) throws EnumerationException
	{
		update(element);
	}

	/** 
	 * Updates MicrobeamManipulation recursively from an XML DOM tree. <b>NOTE:</b> No
	 * properties are removed, only added or updated.
	 * @param element Root of the XML DOM tree to construct a model object
	 * graph from.
	 * @throws EnumerationException If there is an error instantiating an
	 * enumeration during model object creation.
	 */
	public void update(Element element) throws EnumerationException
	{	
		super.update(element);
		String tagName = element.getTagName();
		if (!"MicrobeamManipulation".equals(tagName))
		{
			System.err.println(String.format(
					"WARNING: Expecting node name of MicrobeamManipulation got %s",
					tagName));
			// TODO: Should be its own Exception
			//throw new RuntimeException(String.format(
			//		"Expecting node name of MicrobeamManipulation got %s",
			//		tagName));
		}
		if (element.hasAttribute("Type"))
		{
			// Attribute property which is an enumeration Type
			setType(MicrobeamManipulationType.fromString(
					element.getAttribute("Type")));
		}
		if (element.hasAttribute("ID"))
		{
			// Attribute property ID
			setID(String.valueOf(
					element.getAttribute("ID")));
		}
		// *** IGNORING *** Skipped back reference ROIRef
		// *** IGNORING *** Skipped back reference ExperimenterRef
		// Element property LightSourceSettings which is complex (has
		// sub-elements) and occurs more than once
		NodeList LightSourceSettings_nodeList = element.getElementsByTagName("LightSourceSettings");
		for (int i = 0; i < LightSourceSettings_nodeList.getLength(); i++)
		{
			Element LightSourceSettings_element = (Element) LightSourceSettings_nodeList.item(i);
			addLightSourceSettings(
					new LightSourceSettings(LightSourceSettings_element));
		}
		// *** IGNORING *** Skipped back reference Image_BackReference
	}

	// -- MicrobeamManipulation API methods --


	// Property
	public MicrobeamManipulationType getType()
	{
		return type;
	}

	public void setType(MicrobeamManipulationType type)
	{
		this.type = type;
	}

	// Property
	public String getID()
	{
		return id;
	}

	public void setID(String id)
	{
		this.id = id;
	}

	// Reference which occurs more than once
	public int sizeOfLinkedROIList()
	{
		return roiList.size();
	}

	public List<ROI> copyLinkedROIList()
	{
		return new ArrayList<ROI>(roiList);
	}

	public ROI getLinkedROI(int index)
	{
		return roiList.get(index);
	}

	public ROI setLinkedROI(int index, ROI o)
	{
		return roiList.set(index, o);
	}

	public boolean linkROI(ROI o)
	{
		o.linkMicrobeamManipulation(this);
		return roiList.add(o);
	}

	public boolean unlinkROI(ROI o)
	{
		o.unlinkMicrobeamManipulation(this);
		return roiList.remove(o);
	}

	// Reference
	public Experimenter getLinkedExperimenter()
	{
		return experimenter;
	}

	public void linkExperimenter(Experimenter o)
	{
		experimenter = o;
	}

	public void unlinkExperimenter(Experimenter o)
	{
		if (experimenter == o)
		{
			experimenter = null;
		}
	}

	// Property which occurs more than once
	public int sizeOfLightSourceSettingsList()
	{
		return lightSourceSettingsList.size();
	}

	public List<LightSourceSettings> copyLightSourceSettingsList()
	{
		return new ArrayList<LightSourceSettings>(lightSourceSettingsList);
	}

	public LightSourceSettings getLightSourceSettings(int index)
	{
		return lightSourceSettingsList.get(index);
	}

	public LightSourceSettings setLightSourceSettings(int index, LightSourceSettings lightSourceSettings)
	{
		return lightSourceSettingsList.set(index, lightSourceSettings);
	}

	public void addLightSourceSettings(LightSourceSettings lightSourceSettings)
	{
		lightSourceSettingsList.add(lightSourceSettings);
	}

	public void removeLightSourceSettings(LightSourceSettings lightSourceSettings)
	{
		lightSourceSettingsList.remove(lightSourceSettings);
	}

	// Reference which occurs more than once
	public int sizeOfLinkedImageList()
	{
		return image_BackReferenceList.size();
	}

	public List<Image> copyLinkedImageList()
	{
		return new ArrayList<Image>(image_BackReferenceList);
	}

	public Image getLinkedImage(int index)
	{
		return image_BackReferenceList.get(index);
	}

	public Image setLinkedImage(int index, Image o)
	{
		return image_BackReferenceList.set(index, o);
	}

	public boolean linkImage(Image o)
	{
		return image_BackReferenceList.add(o);
	}

	public boolean unlinkImage(Image o)
	{
		return image_BackReferenceList.remove(o);
	}

	public Element asXMLElement(Document document)
	{
		return asXMLElement(document, null);
	}

	protected Element asXMLElement(Document document, Element MicrobeamManipulation_element)
	{
		// Creating XML block for MicrobeamManipulation
		if (MicrobeamManipulation_element == null)
		{
			MicrobeamManipulation_element =
					document.createElementNS(NAMESPACE, "MicrobeamManipulation");
		}

		if (type != null)
		{
			// Attribute property Type
			MicrobeamManipulation_element.setAttribute("Type", type.toString());
		}
		if (id != null)
		{
			// Attribute property ID
			MicrobeamManipulation_element.setAttribute("ID", id.toString());
		}
		if (roiList != null)
		{
			// Reference property ROIRef
			for (ROI o : roiList)
			{
				Element roiList_element = 
						document.createElementNS(NAMESPACE, "ROIRefRef");
				roiList_element.setAttribute("ID", o.getID());
				MicrobeamManipulation_element.appendChild(roiList_element);
			}
		}
		if (experimenter != null)
		{
			// Element property ExperimenterRef which is complex (has
			// sub-elements)
			MicrobeamManipulation_element.appendChild(experimenter.asXMLElement(document));
		}
		if (lightSourceSettingsList != null)
		{
			// Element property LightSourceSettings which is complex (has
			// sub-elements) and occurs more than once
			for (LightSourceSettings lightSourceSettingsList_value : lightSourceSettingsList)
			{
				MicrobeamManipulation_element.appendChild(lightSourceSettingsList_value.asXMLElement(document));
			}
		}
		if (image_BackReferenceList != null)
		{
			// *** IGNORING *** Skipped back reference Image_BackReference
		}
		return super.asXMLElement(document, MicrobeamManipulation_element);
	}
}
