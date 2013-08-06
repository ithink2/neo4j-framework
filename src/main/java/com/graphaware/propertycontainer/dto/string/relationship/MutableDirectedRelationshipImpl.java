/*
 * Copyright (c) 2013 GraphAware
 *
 * This file is part of GraphAware.
 *
 * GraphAware is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.graphaware.propertycontainer.dto.string.relationship;

import com.graphaware.propertycontainer.dto.common.property.MutableProperties;
import com.graphaware.propertycontainer.dto.common.relationship.BaseDirectedRelationship;
import com.graphaware.propertycontainer.dto.common.relationship.HasTypeDirectionAndProperties;
import com.graphaware.propertycontainer.dto.common.relationship.MutableDirectedRelationship;
import com.graphaware.propertycontainer.dto.string.property.MutablePropertiesImpl;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.util.Map;

/**
 * Simple implementation of {@link com.graphaware.propertycontainer.dto.common.relationship.MutableDirectedRelationship},
 * holding {@link com.graphaware.propertycontainer.dto.common.property.MutableProperties} with {@link String} value representations.
 */
public class MutableDirectedRelationshipImpl extends BaseDirectedRelationship<String, MutableProperties<String>> implements MutableDirectedRelationship<String, MutableProperties<String>> {

    /**
     * Construct a relationship representation. If the start node of this relationship is the same as the end node,
     * the direction will be resolved as {@link org.neo4j.graphdb.Direction#BOTH}.
     *
     * @param relationship Neo4j relationship to represent.
     * @param pointOfView  node which is looking at this relationship and thus determines its direction.
     */
    public MutableDirectedRelationshipImpl(Relationship relationship, Node pointOfView) {
        super(relationship, pointOfView);
    }

    /**
     * Construct a relationship representation. Please note that using this constructor, the actual properties on the
     * relationship are ignored! The provided properties are used instead. If the start node of this relationship is the same as the end node,
     * the direction will be resolved as {@link org.neo4j.graphdb.Direction#BOTH}.
     *
     * @param relationship Neo4j relationship to represent.
     * @param pointOfView  node which is looking at this relationship and thus determines its direction.
     * @param properties   to use as if they were in the relationship.
     */
    public MutableDirectedRelationshipImpl(Relationship relationship, Node pointOfView, MutableProperties<String> properties) {
        super(relationship, pointOfView, properties);
    }

    /**
     * Construct a relationship representation. Please note that using this constructor, the actual properties on the
     * relationship are ignored! The provided properties are used instead. If the start node of this relationship is the same as the end node,
     * the direction will be resolved as {@link org.neo4j.graphdb.Direction#BOTH}.
     *
     * @param relationship Neo4j relationship to represent.
     * @param pointOfView  node which is looking at this relationship and thus determines its direction.
     * @param properties   to use as if they were in the relationship.
     */
    public MutableDirectedRelationshipImpl(Relationship relationship, Node pointOfView, Map<String, String> properties) {
        super(relationship, pointOfView, properties);
    }

    /**
     * Construct a relationship representation with no properties.
     *
     * @param type      type.
     * @param direction direction.
     */
    public MutableDirectedRelationshipImpl(RelationshipType type, Direction direction) {
        super(type, direction);
    }

    /**
     * Construct a relationship representation.
     *
     * @param type       type.
     * @param direction  direction.
     * @param properties props.
     */
    public MutableDirectedRelationshipImpl(RelationshipType type, Direction direction, MutableProperties<String> properties) {
        super(type, direction, properties);
    }

    /**
     * Construct a relationship representation.
     *
     * @param type       type.
     * @param direction  direction.
     * @param properties props.
     */
    public MutableDirectedRelationshipImpl(RelationshipType type, Direction direction, Map<String, String> properties) {
        super(type, direction, properties);
    }

    /**
     * Construct a relationship representation from another one.
     *
     * @param relationship relationships representation.
     */
    public MutableDirectedRelationshipImpl(HasTypeDirectionAndProperties<String, ?> relationship) {
        super(relationship);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected MutableProperties<String> newProperties(Map<String, ?> properties) {
        return new MutablePropertiesImpl(properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProperty(String key, String value) {
        getProperties().setProperty(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeProperty(String key) {
        return getProperties().removeProperty(key);
    }
}