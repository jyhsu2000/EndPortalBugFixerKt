package club.kid7.endportalbugfixer

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class PlayerListener : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        //右鍵點擊方塊
        if (event.action != Action.RIGHT_CLICK_BLOCK) {
            return
        }
        //使用能夠倒出液體的桶子
        if (event.item?.type != Material.WATER_BUCKET
            && event.item?.type != Material.LAVA_BUCKET
            && event.item?.type != Material.PUFFERFISH_BUCKET
            && event.item?.type != Material.SALMON_BUCKET
            && event.item?.type != Material.COD_BUCKET
            && event.item?.type != Material.TROPICAL_FISH_BUCKET
        ) {
            return
        }
        //相鄰方塊（被放置液體的方塊）為終界傳送門
        val adjacentBlock = event.clickedBlock?.getRelative(event.blockFace)
        if (adjacentBlock?.type != Material.END_PORTAL) {
            return
        }

        //取消事件
        event.isCancelled = true
    }
}
