/*******************************************************************************
 * Copyright 2020 grondag
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package grondag.xblocks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.util.math.Direction;

import grondag.xblocks.block.FenceHelper;

@Mixin(WallBlock.class)
public class MixinWallBlock {
	@Inject(at = @At("HEAD"), method = "shouldConnectTo", cancellable = true)
	private void hookShouldConnectTo(BlockState blockState, boolean bl, Direction direction, CallbackInfoReturnable<Boolean> ci) {
		if(FenceHelper.shouldConnect(blockState.getBlock())) {
			ci.setReturnValue(true);
		}
	}
}
