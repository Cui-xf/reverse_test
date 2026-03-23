package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChildLayerDependenciesTracker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005J\u001d\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\bJ+\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0086\bR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "()V", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dependency", "oldDependenciesSet", "oldDependency", "trackingInProgress", "", "onDependencyAdded", "graphicsLayer", "removeDependencies", "", "block", "Lkotlin/Function1;", "withTracking", "onDependencyRemoved", "Lkotlin/Function0;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChildLayerDependenciesTracker {
    private MutableScatterSet<GraphicsLayer> dependenciesSet;
    private GraphicsLayer dependency;
    private MutableScatterSet<GraphicsLayer> oldDependenciesSet;
    private GraphicsLayer oldDependency;
    private boolean trackingInProgress;

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void withTracking(kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.layer.GraphicsLayer, kotlin.Unit> r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.withTracking(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0):void");
    }

    public final boolean onDependencyAdded(GraphicsLayer graphicsLayer) {
        boolean value$iv = this.trackingInProgress;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
        }
        if (this.dependenciesSet != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSet = this.dependenciesSet;
            Intrinsics.checkNotNull(mutableScatterSet);
            mutableScatterSet.add(graphicsLayer);
        } else if (this.dependency != null) {
            MutableScatterSet it = ScatterSetKt.mutableScatterSetOf();
            GraphicsLayer graphicsLayer2 = this.dependency;
            Intrinsics.checkNotNull(graphicsLayer2);
            it.add(graphicsLayer2);
            it.add(graphicsLayer);
            this.dependenciesSet = it;
            this.dependency = null;
        } else {
            this.dependency = graphicsLayer;
        }
        if (this.oldDependenciesSet != null) {
            Intrinsics.checkNotNull(this.oldDependenciesSet);
            return !r0.remove(graphicsLayer);
        }
        if (this.oldDependency != graphicsLayer) {
            return true;
        }
        this.oldDependency = null;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeDependencies(kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.layer.GraphicsLayer, kotlin.Unit> r25) {
        /*
            r24 = this;
            r0 = r25
            r1 = 0
            androidx.compose.ui.graphics.layer.GraphicsLayer r2 = access$getDependency$p(r24)
            if (r2 == 0) goto L15
            r3 = 0
            r0.invoke(r2)
            r4 = 0
            r5 = r24
            access$setDependency$p(r5, r4)
            goto L17
        L15:
            r5 = r24
        L17:
            androidx.collection.MutableScatterSet r2 = access$getDependenciesSet$p(r5)
            if (r2 == 0) goto La6
            r3 = 0
            r4 = r2
            androidx.collection.ScatterSet r4 = (androidx.collection.ScatterSet) r4
            r6 = 0
            java.lang.Object[] r7 = r4.elements
            r8 = r4
            r9 = 0
            long[] r10 = r8.metadata
            int r11 = r10.length
            int r11 = r11 + (-2)
            r12 = 0
            if (r12 > r11) goto L98
        L31:
            r13 = r10[r12]
            r15 = r13
            r17 = 0
            r18 = r1
            r19 = r2
            r1 = r15
            r15 = r3
            r16 = r4
            long r3 = ~r1
            r20 = 7
            long r3 = r3 << r20
            long r3 = r3 & r1
            r20 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r1 = r3 & r20
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L8c
            int r1 = r12 - r11
            int r1 = ~r1
            int r1 = r1 >>> 31
            r2 = 8
            int r1 = 8 - r1
            r3 = 0
        L59:
            if (r3 >= r1) goto L86
            r20 = 255(0xff, double:1.26E-321)
            long r20 = r13 & r20
            r4 = 0
            r22 = 128(0x80, double:6.3E-322)
            int r17 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r17 >= 0) goto L69
            r17 = 1
            goto L6b
        L69:
            r17 = 0
        L6b:
            if (r17 == 0) goto L7d
            int r4 = r12 << 3
            int r4 = r4 + r3
            r17 = r4
            r20 = 0
            r21 = 8
            r2 = r7[r17]
            r0.invoke(r2)
            goto L7f
        L7d:
            r21 = 8
        L7f:
            long r13 = r13 >> r21
            int r3 = r3 + 1
            r2 = 8
            goto L59
        L86:
            r21 = 8
            r2 = 8
            if (r1 != r2) goto La0
        L8c:
            if (r12 == r11) goto L9f
            int r12 = r12 + 1
            r3 = r15
            r4 = r16
            r1 = r18
            r2 = r19
            goto L31
        L98:
            r18 = r1
            r19 = r2
            r15 = r3
            r16 = r4
        L9f:
        La0:
            r19.clear()
            goto La8
        La6:
            r18 = r1
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.removeDependencies(kotlin.jvm.functions.Function1):void");
    }
}
