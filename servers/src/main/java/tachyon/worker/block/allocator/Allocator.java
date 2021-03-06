/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package tachyon.worker.block.allocator;

import java.io.IOException;

import tachyon.worker.block.BlockMetadataManagerView;
import tachyon.worker.block.BlockStoreLocation;
import tachyon.worker.block.meta.TempBlockMeta;

/**
 * Interface for the allocation policy of Tachyon managed data.
 */
public interface Allocator {
  /**
   * Allocates a block from the given block store location under a given view.
   * The location can be a specific location,
   * or {@link BlockStoreLocation#anyTier()} or {@link BlockStoreLocation#anyDirInTier(int)}.
   * The view is generated by a {@link BlockStore}.
   *
   * @param userId the ID of user to apply for the block allocation
   * @param blockId the ID of the block
   * @param blockSize the size of block in bytes
   * @param location the location in block store
   * @param view of the metadata manager
   * @return a temp block meta if success, null otherwise
   * @throws IOException if block location is invalid
   */
  TempBlockMeta allocateBlockWithView(long userId, long blockId, long blockSize,
      BlockStoreLocation location, BlockMetadataManagerView view) throws IOException;
}
