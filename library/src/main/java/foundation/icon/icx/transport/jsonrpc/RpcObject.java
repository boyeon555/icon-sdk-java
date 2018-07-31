/*
 * Copyright 2018 theloop Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package foundation.icon.icx.transport.jsonrpc;

import java.util.HashMap;
import java.util.Set;

/**
 * A read-only data class of RpcObject
 */
public class RpcObject implements RpcField {
    private final HashMap<String, RpcField> fields;

    private RpcObject(HashMap<String, RpcField> fields) {
        this.fields = fields;
    }

    public Set<String> keySet() {
        return fields.keySet();
    }

    public RpcField getValue(String key) {
        return fields.get(key);
    }

    @Override
    public String toString() {
        return "RpcObject(" +
                "fields=" + fields +
                ')';
    }

    /**
     * Builder for RpcObject
     */
    public static class Builder {

        private final HashMap<String, RpcField> fields;

        public Builder() {
            fields = new HashMap<>();
        }

        public Builder put(String key, RpcField value) {
            fields.put(key, value);
            return this;
        }

        public RpcObject build() {
            return new RpcObject(fields);
        }
    }
}