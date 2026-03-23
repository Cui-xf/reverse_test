package androidx.compose.foundation.text.selection;

import android.view.KeyEvent;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: SelectionManager.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"isCopyKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "isCopyKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/selection/SelectionManager;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "selectionMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "foundation_release", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionManager_androidKt {
    /* renamed from: isCopyKeyEvent-ZmokQxo, reason: not valid java name */
    public static final boolean m1383isCopyKeyEventZmokQxo(KeyEvent keyEvent) {
        return KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1003mapZmokQxo(keyEvent) == KeyCommand.COPY;
    }

    public static final Modifier selectionMagnifier(Modifier $this$selectionMagnifier, SelectionManager manager) {
        if (!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null)) {
            return $this$selectionMagnifier;
        }
        return ComposedModifierKt.composed$default($this$selectionMagnifier, null, new C03781(manager), 1, null);
    }

    /* compiled from: SelectionManager.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1, reason: invalid class name and case insensitive filesystem */
    static final class C03781 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ SelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03781(SelectionManager selectionManager) {
            super(3);
            this.$manager = selectionManager;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
            Object value$iv;
            Object value$iv2;
            Object value$iv3;
            $composer.startReplaceGroup(-1914520728);
            ComposerKt.sourceInformation($composer, "C49@2158L7,50@2195L41,52@2303L96,55@2433L560:SelectionManager.android.kt#eksfi3");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1914520728, $changed, -1, "androidx.compose.foundation.text.selection.selectionMagnifier.<anonymous> (SelectionManager.android.kt:49)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer, -1834621149, "CC(remember):SelectionManager.android.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6859boximpl(IntSize.INSTANCE.m6872getZeroYbymL2g()), null, 2, null);
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState magnifierSize$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1834617638, "CC(remember):SelectionManager.android.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$manager);
            final SelectionManager selectionManager = this.$manager;
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Offset invoke() {
                        return Offset.m3934boximpl(m1384invokeF1C5BW0());
                    }

                    /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                    public final long m1384invokeF1C5BW0() {
                        return SelectionManagerKt.m1380calculateSelectionMagnifierCenterAndroidO0kMr_c(selectionManager, SelectionManager_androidKt.C03781.invoke$lambda$1(magnifierSize$delegate));
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            Function0 function0 = (Function0) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1834613014, "CC(remember):SelectionManager.android.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(density);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<Function0<? extends Offset>, Modifier>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Modifier invoke(Function0<? extends Offset> function02) {
                        return invoke2((Function0<Offset>) function02);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Modifier invoke2(final Function0<Offset> function02) {
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Function1<Density, Offset> function1 = new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Offset invoke(Density density2) {
                                return Offset.m3934boximpl(m1385invoketuRUvjQ(density2));
                            }

                            /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
                            public final long m1385invoketuRUvjQ(Density $this$magnifier) {
                                return function02.invoke().getPackedValue();
                            }
                        };
                        final Density density2 = density;
                        final MutableState<IntSize> mutableState = magnifierSize$delegate;
                        return Magnifier_androidKt.m300magnifierjPUL71Q$default(companion, function1, null, new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DpSize dpSize) {
                                m1386invokeEaSLcWc(dpSize.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-EaSLcWc, reason: not valid java name */
                            public final void m1386invokeEaSLcWc(long size) {
                                MutableState<IntSize> mutableState2 = mutableState;
                                Density $this$invoke_EaSLcWc_u24lambda_u240 = density2;
                                SelectionManager_androidKt.C03781.invoke$lambda$2(mutableState2, IntSizeKt.IntSize($this$invoke_EaSLcWc_u24lambda_u240.mo361roundToPx0680j_4(DpSize.m6791getWidthD9Ej5fM(size)), $this$invoke_EaSLcWc_u24lambda_u240.mo361roundToPx0680j_4(DpSize.m6789getHeightD9Ej5fM(size))));
                            }
                        }, 0.0f, true, 0L, 0.0f, 0.0f, false, PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform(), 490, null);
                    }
                };
                $composer.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifierAnimatedSelectionMagnifier = SelectionMagnifierKt.animatedSelectionMagnifier($this$composed, function0, (Function1) value$iv3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return modifierAnimatedSelectionMagnifier;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long invoke$lambda$1(MutableState<IntSize> mutableState) {
            MutableState<IntSize> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().getPackedValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MutableState<IntSize> mutableState, long value) {
            mutableState.setValue(IntSize.m6859boximpl(value));
        }
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final SelectionManager $this$contextMenuBuilder, final ContextMenuState state) {
        return new Function1<ContextMenuScope, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt.contextMenuBuilder.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContextMenuScope contextMenuScope) {
                invoke2(contextMenuScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContextMenuScope $this$null) {
                final ContextMenuState state$iv = state;
                TextContextMenuItems label$iv = TextContextMenuItems.Copy;
                boolean enabled$iv = $this$contextMenuBuilder.isNonEmptySelection$foundation_release();
                final SelectionManager selectionManager = $this$contextMenuBuilder;
                $this$null.item(new ContextMenu_androidKt.AnonymousClass1(label$iv), (10 & 2) != 0 ? Modifier.INSTANCE : null, (10 & 4) != 0 ? true : enabled$iv, (10 & 8) != 0 ? null : null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        selectionManager.copy$foundation_release();
                        ContextMenuState_androidKt.close(state$iv);
                    }
                });
                final ContextMenuState state$iv2 = state;
                TextContextMenuItems label$iv2 = TextContextMenuItems.SelectAll;
                boolean enabled$iv2 = !$this$contextMenuBuilder.isEntireContainerSelected$foundation_release();
                final SelectionManager selectionManager2 = $this$contextMenuBuilder;
                $this$null.item(new ContextMenu_androidKt.AnonymousClass1(label$iv2), (10 & 2) != 0 ? Modifier.INSTANCE : null, (10 & 4) != 0 ? true : enabled$iv2, (10 & 8) != 0 ? null : null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        selectionManager2.selectAll$foundation_release();
                        ContextMenuState_androidKt.close(state$iv2);
                    }
                });
                CollectionsKt.listOf((Object[]) new Unit[]{Unit.INSTANCE, Unit.INSTANCE});
            }
        };
    }
}
