/*
 * Copyright 2020 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.client.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsignedData(
        /**
         * The time in milliseconds that has elapsed since the event was sent.
         * This field is generated by the local homeserver, and may be incorrect if the local time on at least one of the two servers
         * is out of sync, which can cause the age to either be negative or greater than it actually is.
         */
        @Json(name = "age") val age: Long?,
        /**
         *  Optional. The event that redacted this event, if any.
         */
        @Json(name = "redacted_because") val redactedEvent: Event? = null,
        /**
         * The client-supplied transaction ID, if the client being given the event is the same one which sent it.
         */
        @Json(name = "transaction_id") val transactionId: String? = null,
        /**
         * Optional. The previous content for this event. If there is no previous content, this key will be missing.
         */
        @Json(name = "prev_content") val prevContent: Map<String, Any>? = null,
        @Json(name = "m.relations") val relations: AggregatedRelations? = null,
        /**
         * Optional. The eventId of the previous state event being replaced.
         */
        @Json(name = "replaces_state") val replacesState: String? = null

)
